package test.httprequest;

import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试 请求Metering System消息
 * @author wb_shen.chengs
 *
 */
public class TestRequestInfoFromMS {   
    public static void main(String[] args) {   
        try {   
        	HttpRequester request = new HttpRequester();   
            
            Map<String,String> propertys = new HashMap<String, String>();

            /* VM info from metering test server - done 
            String url1 = "http://10.1.157.163:8080/aliyun/QS/VM/RAW";
            propertys.put("HOST", "ms.aliyun.com");
            propertys.put("COLUMN", "core");
            propertys.put("WHERE", "openid,default;pid,vm;bid,1640626172861173;begin_time,1331179200;end_time,1331182800;inst_id,migrate-win2003-vifs");
            */
            
            /* OSS info from metering test server */  
            String url2 = "http://10.1.157.163:8080/aliyun/QS/OSS/RAW";
            propertys.put("HOST", "ms.aliyun.com");
            propertys.put("COLUMN", "cpu;io");
            propertys.put("WHERE", "openid,default; pid, oss; bid, 1640626172861173; begin_time, 1330000000;end_time, 1332729534754;inst_id,migrate-win2003-vifs");// inst_id,migrate-win2003-vifs ?缺少这个请求错误
            
            
            /* SLB info from metering test server 
            String url3 = "http://10.1.157.163:8080/aliyun/QS/SLB/RAW";
            propertys.put("HOST", "ms.aliyun.com");
            propertys.put("COLUMN", "cpu;io");
            propertys.put("WHERE", "openid,default; pid, oss; bid, 1640626172861173; begin_time, 1331179200;end_time, 1331182800;inst_id,migrate-win2003-vifs");// inst_id,migrate-win2003-vifs ?缺少这个请求错误
            */
            
            /* OMS */
            String url4 = "http://10.230.201.85:8080/ACE_RAW";
            propertys.put("HOST", "service.oms.aliyun.com");
            propertys.put("Data", "");
            propertys.put("Authorization", "");
            propertys.put("Content-Type", "utf-8");
            
            HttpRespons hr = request.sendGet(url2, null, propertys);            
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
