package test.json;

import net.sf.json.JSONObject;

public class tesetObject2Json {

	public static void main(String[] args) {
		
		pojo p = new pojo("22","jack");
		
		System.out.println(JSONObject.fromObject(p).toString());//{"id":"22","name":"jack"}
		
		//用json注解给属性名取别名显示
		
		
	}
	
}
