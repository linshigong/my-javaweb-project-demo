package test.httprequest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class SlbBackendRequest {

	public static void main(String[] args) throws Exception {
		
		String client = "http://10.230.130.129:8088";
		String url = "http://localhost:8080/slb/api?region_no=region-test&session=accessid1&sign=xx";
		String url2 = "http://localhost:8080/slb/api?action=create_loadbalancer&region_no=region-test&lb_name=lbname1&lb_type=compact&eip_type=internet&session=accessid1&sign=xx";
		//查询lb pass
		//http://localhost:8080/slb/api?action=query_loadbalancer&region_no=region-test&lb_id=43-region-test&&session=accessid1&sign=xx
		String url3 = client + "/lbs" + "/43-region-test;user_id=1";
		//查询用户lb列表 pass
		String url4 = client + "/lbs" + ";user_id=1";
		//
		String url5 = "http://10.230.130.129:8088/lbs/25-region-test/vips;listeners=" + URLEncoder.encode("[{\"protocol\":\"tcp\",\"frontend_port\":80,\"backend_port\":82,\"config\":{\"scheduler\":\"rr\",\"persistence_timeout\":1000,\"check\":{\"type\":\"vtcp\"}}},{\"protocol\":\"tcp\",\"frontend_port\":83,\"status\":\"inactive\",\"backend_port\":81,\"config\":{\"scheduler\":\"rr\",\"forwardfor\":\"on\",\"keepalive\":\"on\"}}]","utf-8") + ";lb_id=25-region-test;region_id=region-test;user_id=1";
		
		String url6 = "http://10.230.130.129:8088/rspools/rspool1;rs_list=[{\"address\":\"192.168.1.1\"},{\"address\":\"192.168.1.2\"}];lb_id=25-region-test;region_id=region-test;user_id=1";
		
    	HttpRequester request = new HttpRequester();   
        
        HttpRespons hr = request.sendRestRequest(url5, "POST");          
        System.out.println("---------- response ---------");
        System.out.println("url\t\t= "+hr.getUrlString());   
        System.out.println("protocol\t= "+hr.getProtocol());   
        System.out.println("host\t\t= "+hr.getHost());   
        System.out.println("port\t\t= "+hr.getPort());   
        System.out.println("content encoding\t= "+hr.getContentEncoding());   
        System.out.println("method\t\t= "+hr.getMethod());
        System.out.println("content\t\t= "+hr.getContent());
            
		
	}
	
}
