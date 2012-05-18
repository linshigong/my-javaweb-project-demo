package test.httprequest;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试 往MS上推送数据
 * @author wb_shen.chengs
 *
 */
public class TestPushInfoToMS {

	public static void main(String[] args) {
		
		//构造 ace计量消息推送到ms上
		try {   
        	HttpRequester request = new HttpRequester();   
            
            Map<String,String> propertys = new HashMap<String, String>();
            HttpRespons hr = request.sendGet("", null, propertys);            
            System.out.println("---------- response ---------");
            System.out.println("url\t\t= "+hr.getUrlString());   
            System.out.println("protocol\t= "+hr.getProtocol());   
            System.out.println("host\t\t= "+hr.getHost());   
            System.out.println("port\t\t= "+hr.getPort());   
            System.out.println("content encoding\t= "+hr.getContentEncoding());   
            System.out.println("method\t\t= "+hr.getMethod());
            
            System.out.println(hr.getContent());   
        } catch (Exception e) {   
            e.printStackTrace();   
        }   
		
	}
	
}
