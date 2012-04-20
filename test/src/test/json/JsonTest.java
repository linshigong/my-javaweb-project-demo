package test.json;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import test.Pojo;

public class JsonTest {

	public static void main(String[] args) {
		
		Pojo pojo = new Pojo("1","jack");
		JSONObject jsonObject = JSONObject.fromObject(pojo);
		//输出：{"id":"1","name":"jack"}
		System.out.println(jsonObject);
		
		String jsonStriing = "{\"id\":\"1\",\"name\":\"jack\"}";
		JSONObject pojoJson = JSONObject.fromObject(jsonStriing);
		Pojo fromJsonPojo = (Pojo)JSONObject.toBean(pojoJson, Pojo.class);
		//输出：id=1 name=jack
		System.out.println(fromJsonPojo);

		MyResponse mr =  new MyResponse();
		Map<String,String> map = new HashMap<String, String>();
		map.put("id", "1");
		map.put("name", "jack");
		Map<String,String> map2 = new HashMap<String, String>();
		map2.put("id", "2");
		map2.put("name", "tom");
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		list.add(map);
		list.add(map2);
		mr.setGetMetricData(list);
		//输出：{"getMetricData":[{"id":"1","name":"jack"},{"id":"2","name":"tom"}]}
		System.out.println(JSONObject.fromObject(mr));
		
		//对于大写开头的key，用replace替换，待找更好方法
		String str = "{\"GetMetricData\":[{\"__time__\":\"1323964800\",\"avg_bandwidth_pv\":\"88995.63832366583\"},{\"__time__\":\"1334678400\",\"avg_bandwidth_pv\":\"51914.24406006078\"}]}";
		str = str.replace("GetMetricData", "getMetricData");
		MyResponse fromJsonStr = (MyResponse)JSONObject.toBean(JSONObject.fromObject(str),MyResponse.class);
		System.out.println(fromJsonStr);
		System.out.println(JSONObject.fromObject(fromJsonStr));
		
		String str2 = "{\"Error\":{\"Code\":\"ParameterInvalid\",\"Message\":\"The parameter is invalid\"}}";
		str2 = str2.replace("Error", "error");
		MyResponse fromJsonStr2 = (MyResponse)JSONObject.toBean(JSONObject.fromObject(str2),MyResponse.class);
		System.out.println(fromJsonStr2);
		System.out.println(JSONObject.fromObject(fromJsonStr2));
		System.out.println(JSONArray.fromObject(fromJsonStr.getGetMetricData()));//[{"__time__":"1323964800","avg_bandwidth_pv":"88995.63832366583"},{"__time__":"1334678400","avg_bandwidth_pv":"51914.24406006078"}]
		
		
	}
	
}
