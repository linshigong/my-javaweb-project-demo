package test.json;

import net.sf.json.JSONObject;
import test.json.pojo2.pojo3;

/**
 * 内部类的Bean转json以及Json转Bean的问题
 */
public class JsonObjectToBeanTest {

    public static void main(String[] args) {
        
        /** 普通Bean **/
        pojo2 p = new pojo2();
        p.setMsg("successful");
        p.setCode(200);
        p.setData(null);
        System.out.println(JSONObject.fromObject(p));
        
        //
        String jsonObject1  = "{\"code\":200,\"data\":null,\"msg\":\"successful\"}";
        System.out.println(JSONObject.toBean(JSONObject.fromObject(jsonObject1), pojo2.class));
        
        /** 内部类Bean **/
        pojo3 p3 = new pojo3();
        p3.setMsg("successful");
        p3.setCode(200);
        p3.setData(null);
        //Property 'code' has no getter method in class 'class test.json.pojo2$pojo3'
        System.out.println(JSONObject.fromObject(p3));
        
        //
        String jsonObject2  = "{\"code\":200,\"data\":null,\"msg\":\"successful\"}";
        //Property 'code' has no setter method in class 'class test.json.pojo2$pojo3'
        System.out.println(JSONObject.toBean(JSONObject.fromObject(jsonObject2), pojo3.class));
                
    }
    
}
