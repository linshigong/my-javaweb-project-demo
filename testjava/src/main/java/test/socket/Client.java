package test.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

public class Client {

	public static void main(String[] args) throws Exception {
		
		HttpClient client = new HttpClient();
		client.getHostConfiguration().setHost("localhost",9090);
		
		HttpMethod method = new GetMethod(); 
		method.setPath("/test");
//		method.setRequestHeader("Transfer-Coding", "chunked");
		client.executeMethod(method);
		
		System.out.println(method.getStatusCode());
		System.out.println(method.getStatusText());
		BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));
		String line = null;
		while((line = reader.readLine()) != null){
			System.out.println(line);
		}
		
		//
		reader.close();
		method.releaseConnection();
	}
	
}
