package test.nio.example;

import net.sf.json.JSONObject;

public class JsonParser {
     
     private static JSONObject mJson;
     
     public synchronized static String get(String json,String key) {
         mJson = JSONObject.fromObject(json);
         return mJson.getString(key);
     }
 }