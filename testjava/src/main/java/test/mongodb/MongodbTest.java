package test.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

/**
 * start 
 * import driver
 * use
 */
public class MongodbTest {
	
	public static void main(String[] args) throws Exception {
		
		Mongo mongo = new Mongo("localhost", 28000);
		System.out.println(mongo);
		//
		DB db = mongo.getDB("local");
		DBObject dbObject = new BasicDBObject();
		dbObject.put("name", "jack");
		dbObject.put("age", 22);
		System.out.println(db.getCollectionNames());
		//
		DBCollection dBCollection = db.getCollection("tempList");
		System.out.println(dBCollection.find());
		System.out.println(dBCollection.count());;
		System.out.println(dBCollection.distinct("name"));
		
	}
	
}
