package test.chuned;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 * chunked方式读取数据
 * 1.通过socket发送http chunked响应(socket包中测试类)
 * 2.读取chunked响应
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
		String uri = "http://10.250.6.33/open/services";
		String uri2 = "http://localhost:8080/javaweb/chunked";
		GetMethod  postMethod = new GetMethod(uri2);
//		postMethod.
//		postMethod.setContentChunked(true);
		client.executeMethod(postMethod);
		if(postMethod.getResponseBodyAsStream() != null){
			printContent(postMethod.getResponseBodyAsStream());
		}
		
		postMethod.releaseConnection();
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
		
	}
	
	public static void printContent(InputStream in) throws Exception{
		BufferedReader reader2 = new BufferedReader(new InputStreamReader(in,"utf-8"));
		String line2 = null;
		while((line2=reader2.readLine()) != null){
			System.out.println(line2);
		}
	}
	
}
