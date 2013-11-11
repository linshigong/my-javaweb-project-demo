package test.chunked;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 * chunked方式读取数据
 * 1.通过socket发送http chunked响应(socket包中测试类)
 * 2.读取chunked响应(服务端以sleep方式模拟块的发送)
 */
public class HttpChunkedTest {

	public static void main(String[] args) throws Exception {
		/********************* 1. 非chunked方式读取 ***********************
		URL url = new URL("http://www.baidu.com");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		for(Entry<String, List<String>> entry:conn.getHeaderFields().entrySet()){
			System.out.println("header:"+entry.getKey()+"="+entry.getValue());
		}
		//read
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(conn.getInputStream(),Charset.forName("gbk")));
		
		String line = null;
		while((line=reader.readLine()) != null){
			System.out.println(line);
		}
		//close
		reader.close();
		conn.disconnect();
		*/
		
		/********************* 2. chunked方式读取 ************************/
//		URL url2 = new URL("http","localhost",9090,"");
		HttpClient client = new HttpClient();
		String url = "http://10.250.6.33/open/services";
		String url4 = "http://tns.simba.taobao.com";
		String url5 = "http://jigsaw.w3.org/HTTP/ChunkedScript";
		String url2 = "http://localhost:8080/javaweb/chunked";
		String url3 = "http://10.250.6.33/open/services?sign=7T0%2FUxOoo3umsJP6lKu35Q%3D%3D&timestamp=2013-03-07+15%3A18%3A08&session=HM6WYOQQLcoA2%2FBHNX1dnw%3D%3D&zone_id=AT-HOUYIDEV-A&sign_type=MD5&region_id=AT-HOUYIDEV&action=describe_idcisp_data";
		String url6 = "http://10.250.8.214/javaweb/chunked";
		
		
		GetMethod  postMethod = new GetMethod(url2);
		client.executeMethod(postMethod);
		
		for(Header header: postMethod.getRequestHeaders()){
			System.out.println(header.getName()+":"+header.getValue());
		}
		System.out.println();
		for(Header header: postMethod.getResponseHeaders()){
			System.out.println(header.getName()+":"+header.getValue());
		}
		
		//read
		if(postMethod.getResponseBodyAsStream() != null){
			printContent(postMethod.getResponseBodyAsStream());
		}
		
		
		/*
		URL url2 = new URL("http://localhost:9090");
		HttpURLConnection conn2 = (HttpURLConnection)url2.openConnection();
		for(Entry<String, List<String>> entry:conn2.getHeaderFields().entrySet()){
			System.out.println("header:"+entry.getKey()+"="+entry.getValue());
		}
		//read
		
		System.out.println(conn2.getContentEncoding());
		BufferedReader reader2 = new BufferedReader(
				new InputStreamReader(conn2.getInputStream(),"utf-8"));
		
		String line2 = null;
		while((line2=reader2.readLine()) != null){
			System.out.println(line2);
		}
		
		//close
		reader2.close();
		*/
//		conn2.disconnect();
		postMethod.releaseConnection();
		
	}
	
	public static void printContent(InputStream in) throws Exception{
		//以行的方式处理
		BufferedReader reader2 = new BufferedReader(new InputStreamReader(in,"utf-8"));
		String line = null;
		while((line=reader2.readLine()) != null){
			if(!"0".equals(line) && JSONUtils.mayBeJSON(line)){//is json format
				JSON jsonObj = null;
				if(line.startsWith("[")){
					jsonObj = JSONArray.fromObject(line);
				}else{
					jsonObj = JSONObject.fromObject(line);
				}
				System.out.println("jsonObj="+jsonObj);
			}else{
				System.out.println(line);
			}
		}
		
/*		//以chunked流的方式处理
		InputStream chunkedIn = (InputStream)in;
		
		StringBuffer sb = new StringBuffer();
//		byte[] byteArr = new byte[100];
//		OutputStream out = new ByteOutputStream();
		
		int i = 0;
		while((i = chunkedIn.read()) != -1){
			sb.append((char)i);
		}
		System.out.println(sb.toString());
		in.close();
//		out.close();
*/		
	}
	
}
