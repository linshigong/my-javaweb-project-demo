package test.memcache.myclient;

import test.memcache.memchaceclientapi.com.meetup.memcached.MemcachedClient;
import test.memcache.memchaceclientapi.com.meetup.memcached.SockIOPool;

/**
 * test memcache 
 */
public class test {

	public static void main(String[] args) {
		
		MemcachedClient mc = new MemcachedClient();
		
		mc.add("a", 1);
		
		System.out.println(mc.get("a"));
		
	}
	
	
	//inital iopool
	static {
		String[] serverlist = { "192.168.232.162:12000" };

		SockIOPool pool = SockIOPool.getInstance();
		pool.setServers(serverlist);
		pool.initialize();	
	}

	
}
