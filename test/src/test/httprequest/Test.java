package test.httprequest;

import java.util.HashMap;
import java.util.Map;

public class Test {   
    public static void main(String[] args) {   
        try {   
            String url = "http://www.csdn.net";
            String url2 = "http://localhost:8080/jersey/open/hello";
            String url3 = "http://metering.aliyun-inc.com:8080/aliyun/QS/OSS/RAW";
        	HttpRequester request = new HttpRequester();   
            
            
            Map<String,String> propertys = new HashMap<String, String>();
            propertys.put("columns", "storage");
            propertys.put("where", "openid=ace;pid=oss;bid=26842;inst_id=test;begin_time=13123121400;end_time=132123241500");
            String[] metaArr = {"uid","inst_id","time","usetime","total_in","total_out","tcp_flow_in","tcp_flow_out","http_flow_in","http_flow_out","vip_type","rs","flow_detail","region_id","end_time"};
            //"uid,string;inst_id,string; time, integer; usetime,integer; total_in,integer;total_out,integer;tcp_flow_in,integer;tcp_flow_out,integer;http_flow_in,integer;http_flow_out,integer;vip_type,string;rs,integer;flow_detail,string;region_id,string;end_time,integer;"
//            for(String str:metaArr){
//            	propertys.put(str, "1");
//            }
//            HttpRespons hr = request.sendGet(url3);
            HttpRespons hr = request.sendGet(url3, null, propertys);
    
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
