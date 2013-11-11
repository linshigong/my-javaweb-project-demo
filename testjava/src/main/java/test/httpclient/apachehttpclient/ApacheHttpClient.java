package test.httpclient.apachehttpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

import test.httpclient.jettyhttpclient.JettyHttpClient.HttpUtil;

/**
 * 测试Apache Httpclient
 * 
 * 待？
 * 
 * 对于Response流，要读取结束后，再release连接，避免报：connection reset的socket异常
 * 
 * 服务端是否支持长连接，即connection:keep-alive是否有效，否则服务器响应完毕后就关闭连接，就会报上面的异常
 * 
 * 
 */
public class ApacheHttpClient {

	public static void main(String[] args) {
		
		//若为URL需要设置http前缀，否则认为是URI，若为设置host则报host name is null
		//测试用的服务地址，保证服务端不会关闭连接，可模拟服务端响应来测试以保证服务端的环境正常，比如用下面本地的tomcat的servlet返回HTTP响应
		String url = "http://220.181.112.143/";//baidu
		String url2 = "http://localhost:8080/examples/servlets/servlet/HelloWorldExample";
		String url3 = "http://10.230.223.191:9999/resource/bigregion?district_id=2";
		final String currentUrl = url3;
		
		int loopNum = 500;
		
		for(int i=0;i<5;i++){
			System.out.println("Times="+i);
			testWithMultiThreadedHttpConnectionManager(currentUrl,loopNum);
			
			testWithSimpleHttpConnectionManager(currentUrl,loopNum);
			
			testWithJettyHttpClient(currentUrl, loopNum);
		}
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
	
	/* 测试jetty http client */
	private static void testWithJettyHttpClient(final String url,int loopNum) {
		
		ExecutorService executorService2 = Executors.newFixedThreadPool(10);
		long before3 = System.currentTimeMillis();
		for(int i=0;i<loopNum;i++){
			executorService2.submit(new Runnable() {
				
				@Override
				public void run() {
					HttpUtil.send(url);
				}
			});
		}
		
		executorService2.shutdown();
		long use3 = 0;
		try {
			executorService2.awaitTermination(20, TimeUnit.SECONDS);
			use3 = System.currentTimeMillis()-before3;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Case3="+use3+" execute num="+HttpUtil.num);
		
	}

	public static class HttpUtils{
		
		
		private final static HttpClient client = new HttpClient(new MultiThreadedHttpConnectionManager());
		
		static {
			HttpConnectionManagerParams params = client.getHttpConnectionManager().getParams();
			params.setConnectionTimeout(1000 * 30);
			params.setDefaultMaxConnectionsPerHost(10240);//默认最大连接数
			params.setMaxTotalConnections(10240);
			params.setSoTimeout(1000 * 30);
			System.out.println("Tcp NoDelay="+params.getTcpNoDelay());
			params.setTcpNoDelay(true);//有数据就发，不缓存;默认为true
		}
		
		//
		public static Object send(HttpMethod httpMethod){
			
			StringBuilder sb = new StringBuilder();
			try {
				client.executeMethod(httpMethod);
				
				String resp = httpMethod.getResponseBodyAsString();
				
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
