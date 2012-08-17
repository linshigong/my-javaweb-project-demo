package test.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class tesetObject2Json {

	public static void main(String[] args) {
		
		pojo p = new pojo("22","jack");
		
		System.out.println(JSONObject.fromObject(p).toString());//{"id":"22","name":"jack"}
		
		//用json注解给属性名取别名显示
		
		String map = "{\"1.1.1.3\":\"vm3\",\"1.1.1.1\":\"vm1\",\"1.1.1.2\":\"vm2\"}";
		Map<String,String> nameIpMap = new HashMap<String, String>();
		nameIpMap.put("1.1.1.1", "vm1");
		nameIpMap.put("1.1.1.2", "vm2");
		nameIpMap.put("1.1.1.3", "vm3");
		
		System.out.println(JSONObject.fromObject(nameIpMap));
		
		System.out.println(((Map<String,String>)JSONObject.toBean(JSONObject.fromObject(map),HashMap.class)).get("1.1.1.1"));
		
		String jsonStr = "{\"code\":  200,\"desc\":  \"Success\",\"isSuccess\":  \"TRUE\",\"vmName\":  [    [      \"10.250.25.61\",      \"newtest118\"    ],    [      \"10.250.25.50\",      \"tesetvm-zhongjian-8-11\"    ]  ]}";
		JSONArray jsonVmNames = JSONObject.fromObject(jsonStr).getJSONArray("vmName");
		System.out.println(jsonVmNames.getJSONArray(0));
		System.out.println(jsonVmNames.getJSONArray(0).get(0));
		System.out.println(jsonVmNames);
		
	}
	
}
