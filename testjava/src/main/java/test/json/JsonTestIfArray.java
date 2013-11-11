package test.json;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

public class JsonTestIfArray {

	public static void main(String[] args) {
		String str6 = "[{\"protocol\":\"tcp\",\"frontend_port\":80,\"backend_port\":80,\"config\":{\"scheduler\":\"rr\",\"persistence_timeout\":1000,\"check\":{\"type\":\"vtcp\"}}},{\"protocol\":\"tcp\",\"frontend_port\":80,\"status\":\"inactive\",\"backend_port\":80,\"config\":{\"scheduler\":\"rr\",\"forwardfor\":\"on\",\"keepalive\":\"on\"}}]";
		String str7 = "[{\"protocol\":\"tcp\",\"frontend_port\":80,\"backend_port\":80,\"config\":{\"scheduler\":\"rr\",\"persistence_timeout\":1000,\"check\":{\"type\":\"vtcp\"}}},{\"protocol\":\"tcp\",\"frontend_port\":80,\"status\":\"inactive\",\"backend_port\":80,\"config\":{\"scheduler\":\"rr\",\"forwardfor\":\"on\",\"keepalive\":\"on\"}}]";
		String str8 = "[{\"protocol\":\"tcp\",\"frontend_port\":80,\"backend_port\":80,\"config\":{\"scheduler\":\"rr\",\"persistence_timeout\":1000,\"check\":{\"type\":\"vtcp\"}}},{\"protocol\":\"tcp\",\"frontend_port\":80,\"status\":\"inactive\",\"backend_port\":80,\"config\":{\"scheduler\":\"rr\",\"forwardfor\":\"on\",\"keepalive\":\"on\"}}]";
		if(JSONUtils.isArray(str8)){
		    System.out.println(JSONArray.fromObject(str8));
		}else{
		    System.out.println(JSONObject.fromObject(str8));
		}
	}
	
}
