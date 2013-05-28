package test.httpclient.apachehttpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

/**
 * 测试Apache Httpclient
 * 
 * 待？
 * 
 * 对于Response流，要读取结束后，再release连接，避免报：connection reset的socket异常
 * 
 * 
 */
public class ApacheHttpClient {

	public static void main(String[] args) {
		
		//若为URL需要设置http前缀，否则认为是URI，若为设置host则报host name is null
		//测试用的服务地址，保证服务端不会关闭连接，可模拟服务端响应来测试以保证服务端的环境正常，比如用下面本地的tomcat的servlet返回HTTP响应
		final String url = "http://localhost:8080/examples/servlets/servlet/HelloWorldExample";
		
		int loopNum = 1000;
		
		testWithMultiThreadedHttpConnectionManager(url,loopNum);
		
		testWithSimpleHttpConnectionManager(url,loopNum);
		
	}
	
	/* 测试单连接复用SimpleHttpConnectionManager */
	private static void testWithSimpleHttpConnectionManager(final String url,int loopNum) {
		
		ExecutorService executorService2 = Executors.newFixedThreadPool(10);
		long before2 = System.currentTimeMillis();
		for(int i=0;i<loopNum;i++){
			executorService2.submit(new Runnable() {
				
				@Override
				public void run() {
					HttpMethod method = new GetMethod(url);
					HttpUtils.send2(method);
				}
			});
		}
		
		executorService2.shutdown();
		long use2 = 0;
		try {
			executorService2.awaitTermination(20, TimeUnit.SECONDS);
			use2 = System.currentTimeMillis()-before2;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Case2="+use2);
		
	}

	/* 线程池测试多连接复用MultiThreadedHttpConnectionManager */
	private static void testWithMultiThreadedHttpConnectionManager(final String url,int loopNum) {
		
		long before = System.currentTimeMillis();
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for(int i=0;i<loopNum;i++){
			executorService.submit(new Runnable() {
				
				@Override
				public void run() {
					HttpMethod method = new GetMethod(url);
					HttpUtils.send(method);
				}
			});
		} 
		
		executorService.shutdown();
		long use1 = 0;
		try {
			executorService.awaitTermination(20, TimeUnit.MINUTES);
			use1 = System.currentTimeMillis()-before;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Case1="+use1);
		
	}


	public static class HttpUtils{
		
		
		private final static HttpClient client = new HttpClient(new MultiThreadedHttpConnectionManager());
		
		static {
			HttpConnectionManagerParams params = client.getHttpConnectionManager().getParams();
			params.setConnectionTimeout(1000 * 30);
			params.setDefaultMaxConnectionsPerHost(10240);
			params.setMaxTotalConnections(10240);
			params.setSoTimeout(1000 * 30);
			params.setTcpNoDelay(true);//有数据就发，不缓存
		}
		
		//
		public static Object send(HttpMethod httpMethod){
			
			StringBuilder sb = new StringBuilder();
			try {
				client.executeMethod(httpMethod);
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(httpMethod.getResponseBodyAsStream()));
				String line = null;
				while((line = reader.readLine()) != null){
					sb.append(line);
				}
//				System.out.println(sb.toString());
				reader.close();
				
			} catch (HttpException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				httpMethod.releaseConnection();
			}
			
			return sb.toString();
		}
		
		public static Object send2(HttpMethod httpMethod){
			
			String response = null;
			
			try {
				new HttpClient().executeMethod(httpMethod);
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(httpMethod.getResponseBodyAsStream()));
				StringBuilder sb = new StringBuilder();
				String line = null;
				while((line = reader.readLine()) != null){
					sb.append(line);
				}
				reader.close();
				
			} catch (HttpException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				httpMethod.releaseConnection();
			}
			
			return response;
		}
		
	}
	
}
