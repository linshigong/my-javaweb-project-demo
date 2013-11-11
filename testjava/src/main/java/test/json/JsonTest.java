package test.json;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.ezmorph.bean.MorphDynaBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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
		
		//测试 json转换为map对象
		String str3 = "{\"code\":200,\"msg\":\"successful\",\"data\":{ \"lb_id\":\"123\",\" eip\":\"10.250.6.36\"}}";
		String str4 = "{\"code\":200,\"msg\":\"successful\",\"data\":{\"port\":80,\"protocol\":\"tcp\",\"status\":\"stopped\",\"config\":{\"schedule\":\"rr\",\"persistence_timeout\":0,\"check\":{}}}}";
		Map<String,Object> map3 = (Map<String,Object>)JSONObject.toBean(JSONObject.fromObject(str4),HashMap.class);
		System.out.println(map3.get("msg"));//successful
		MorphDynaBean morphDynaBean= (MorphDynaBean)map3.get("data");
		System.out.println(morphDynaBean);//successful
		
		System.out.println((String)null);
		
		//
		String str5 = "{\"data\":{\"frontend_port\":8080,\"lb_id\":\"36-region1\",\"rules\":[{\"name\":\"rule1\",\"domain\":\"www.wqwqwq1.com\",\"rs_pool_name\":\"testpool1\",\"scheduler\":\"wlc\",\"check\":{\"type\":\"http\",\"timeout\":10,\"up\":3,\"down\":3,\"interval\":10},\"sticky_session\":{\"type\":\"server\",\"timeout\":5,\"cookie\":\"hello\"},\"private_header\":{\"a\":\"a\"}},{\"name\":\"rule2\",\"domain\":\"www.wyz.com\",\"rs_pool_name\":\"testpool1\",\"scheduler\":\"wlc\",\"check\":{\"type\":\"http\",\"timeout\":10,\"up\":3,\"down\":3,\"interval\":10},\"sticky_session\":{\"type\":\"server\",\"timeout\":5,\"cookie\":\"helloworld\"},\"private_header\":{\"a\":\"a\"}}]},\"code\":200,\"msg\":\"successful\"}";
		Map map4 = (Map)JSONObject.toBean(JSONObject.fromObject(str5),HashMap.class);
		System.out.println(map4);
		
		//
		String str6 = "[{\"protocol\":\"tcp\",\"frontend_port\":80,\"backend_port\":80,\"config\":{\"scheduler\":\"rr\",\"persistence_timeout\":1000,\"check\":{\"type\":\"vtcp\"}}},{\"protocol\":\"tcp\",\"frontend_port\":80,\"status\":\"inactive\",\"backend_port\":80,\"config\":{\"scheduler\":\"rr\",\"forwardfor\":\"on\",\"keepalive\":\"on\"}}]";
		String str7 = "[{\"protocol\":\"tcp\",\"frontend_port\":80,\"backend_port\":80,\"config\":{\"scheduler\":\"rr\",\"persistence_timeout\":1000,\"check\":{\"type\":\"vtcp\"}}},{\"protocol\":\"tcp\",\"frontend_port\":80,\"status\":\"inactive\",\"backend_port\":80,\"config\":{\"scheduler\":\"rr\",\"forwardfor\":\"on\",\"keepalive\":\"on\"}}]";
		String str8 = "[{\"protocol\":\"tcp\",\"frontend_port\":80,\"backend_port\":80,\"config\":{\"scheduler\":\"rr\",\"persistence_timeout\":1000,\"check\":{\"type\":\"vtcp\"}}},{\"protocol\":\"tcp\",\"frontend_port\":80,\"status\":\"inactive\",\"backend_port\":80,\"config\":{\"scheduler\":\"rr\",\"forwardfor\":\"on\",\"keepalive\":\"on\"}}]";
		System.out.println(JSONArray.fromObject(str8));
		
		//
		String str9 = "[{\"key\":\"value\"},{\"key1\":\"value\"}]";
		String str10 = "[\"10.230.129.49\"]";
		System.out.println(JSONArray.fromObject(str10));
		
		//
		String str11 = "{\"code\":200,\"data\":{\"tcp_internet_bandwidth\":0,\"http_internet_rx\":0,\"end_time\":\"2012-05-06 23:10:10\",\"http_internet_bandwidth\":0,\"tcp_internet_tx\":0,\"lb_id\":\"83-tr\",\"start_time\":\"2012-05-06 05:10:10\",\"http_internet_tx\":0,\"tcp_internet_rx\":477},\"msg\":\"successful\"}";
		System.out.println(JSONObject.fromObject(str11));
		
		//
		String str12 = "{\"code\":200,\"data\":{\"total\":32,\"page_size\":10,\"end_time\":\"2012-05-06 23:10:10\",\"start_time\":\"2012-05-06 05:10:10\",\"page_no\":1,\"loadbalancers\":[{\"http_internet_bandwidth\":0,\"http_internet_rx\":0,\"http_internet_tx\":0,\"loadbalancer_id\":\"1\",\"tcp_internet_bandwidth\":0,\"tcp_internet_rx\":0,\"tcp_internet_tx\":0},{\"http_internet_bandwidth\":0,\"http_internet_rx\":0,\"http_internet_tx\":0,\"loadbalancer_id\":\"2\",\"tcp_internet_bandwidth\":0,\"tcp_internet_rx\":0,\"tcp_internet_tx\":0},{\"http_internet_bandwidth\":0,\"http_internet_rx\":0,\"http_internet_tx\":0,\"loadbalancer_id\":\"3\",\"tcp_internet_bandwidth\":0,\"tcp_internet_rx\":0,\"tcp_internet_tx\":0},{\"http_internet_bandwidth\":0,\"http_internet_rx\":0,\"http_internet_tx\":0,\"loadbalancer_id\":\"4\",\"tcp_internet_bandwidth\":0,\"tcp_internet_rx\":0,\"tcp_internet_tx\":0},{\"http_internet_bandwidth\":0,\"http_internet_rx\":0,\"http_internet_tx\":0,\"loadbalancer_id\":\"5\",\"tcp_internet_bandwidth\":0,\"tcp_internet_rx\":0,\"tcp_internet_tx\":0},{\"http_internet_bandwidth\":0,\"http_internet_rx\":0,\"http_internet_tx\":0,\"loadbalancer_id\":\"6\",\"tcp_internet_bandwidth\":0,\"tcp_internet_rx\":0,\"tcp_internet_tx\":0},{\"http_internet_bandwidth\":0,\"http_internet_rx\":0,\"http_internet_tx\":0,\"loadbalancer_id\":\"7\",\"tcp_internet_bandwidth\":0,\"tcp_internet_rx\":0,\"tcp_internet_tx\":0},{\"http_internet_bandwidth\":0,\"http_internet_rx\":0,\"http_internet_tx\":0,\"loadbalancer_id\":\"8\",\"tcp_internet_bandwidth\":0,\"tcp_internet_rx\":0,\"tcp_internet_tx\":0},{\"http_internet_bandwidth\":0,\"http_internet_rx\":0,\"http_internet_tx\":0,\"loadbalancer_id\":\"9\",\"tcp_internet_bandwidth\":0,\"tcp_internet_rx\":0,\"tcp_internet_tx\":0},{\"http_internet_bandwidth\":0,\"http_internet_rx\":0,\"http_internet_tx\":0,\"loadbalancer_id\":\"10\",\"tcp_internet_bandwidth\":0,\"tcp_internet_rx\":0,\"tcp_internet_tx\":0}]},\"msg\":\"successful\"}";
		System.out.println(JSONObject.fromObject(str12));
		
		//
		String str13 = "[{},{}]";
		System.out.println(JSONArray.fromObject(str13));
		
		String str14 = "[1,2,3,4,5,6]";
		JSONArray arr14 = JSONArray.fromObject(str14);
		System.out.println("arr14="+arr14);//[1,2,3,4,5,6]
		System.out.println(arr14.subList(0, 2));//[1, 2]
		System.out.println(arr14.subList(1, 2));//[2]
		
	}
	
}
