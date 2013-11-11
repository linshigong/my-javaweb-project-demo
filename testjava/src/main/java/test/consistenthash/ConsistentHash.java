package test.consistenthash;

import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 
 * For completeness here is a simple implementation in Java. In order for consistent hashing 
 * to be effective it is important to have a hash function that mixes well. Most implementations 
 * of Object's hashCode do not mix well - for example, they typically produce a restricted number 
 * of small integer values - so we have a HashFunction interface to allow a custom hash function 
 * to be used. MD5 hashes are recommended here.<p>
 * 
 * The circle is represented as a sorted map of integers, which represent the hash values, to caches (of type T here).<p>
 * 
 * When a ConsistentHash object is created each node is added to the circle map a number of times (controlled 
 * by numberOfReplicas). The location of each replica is chosen by hashing the node's name along with a numerical 
 * suffix, and the node is stored at each of these points in the map.<p>
 * 
 * To find a node for an object (the get method), the hash value of the object is used to look in the map. 
 * Most of the time there will not be a node stored at this hash value (since the hash value space is 
 * typically much larger than the number of nodes, even with replicas), so the next node is found by looking 
 * for the first key in the tail map. If the tail map is empty then we wrap around the circle by getting the 
 * first key in the circle.
 * 
 *@see 
 *<a href="https://weblogs.java.net/blog/2007/11/27/consistent-hashing">consistent-hashing</a>
 */
public class ConsistentHash<T> {

 private final HashFunction hashFunction;
 private final int numberOfReplicas;//number of copies
 private final SortedMap<Integer, T> circle = new TreeMap<Integer, T>();//hash circle

 /**
  * 
  * @param hashFunction
  * @param numberOfReplicas
  * @param nodes storage nodes which will hold cache values
  */
 public ConsistentHash(HashFunction hashFunction, int numberOfReplicas, Collection<T> nodes) {
   this.hashFunction = hashFunction;
   this.numberOfReplicas = numberOfReplicas;

   for (T node : nodes) {
     add(node);
   }
 }

 public void add(T node) {
   for (int i = 0; i < numberOfReplicas; i++) {
     circle.put(hashFunction.hash(node.toString() + i), node);
   }
 }

 public void remove(T node) {
   for (int i = 0; i < numberOfReplicas; i++) {
     circle.remove(hashFunction.hash(node.toString() + i));
   }
 }

 public T get(Object key) {
   if (circle.isEmpty()) {
     return null;
   }
   int hash = hashFunction.hash(key);
   if (!circle.containsKey(hash)) {
     SortedMap<Integer, T> tailMap = circle.tailMap(hash);
     hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
   }
   return circle.get(hash);
 }

}
