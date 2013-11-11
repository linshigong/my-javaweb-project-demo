package test.chunked;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;

import org.eclipse.jetty.client.ContentExchange;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.io.Buffer;
import org.eclipse.jetty.io.ByteArrayBuffer;

public class JettyHttpclientTest {

	public static void main(String[] args) {
		
		test1();
		Thread.currentThread().setName("main test Thread");
//		test2();

	}

	public static void test1() {
		HttpClient client = new HttpClient();
		client.setConnectorType(HttpClient.CONNECTOR_SELECT_CHANNEL);
		try {
			client.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// create the exchange object, which lets you define where you want to
		// go
		// and what you want to do once you get a response
		final ContentExchange exchange = new ContentExchange() {
			// define the callback method to process the response when you get
			// it back
			protected void onResponseComplete() throws IOException {
				String responseContent = this.getResponseContent();

				// do something with the response content
				System.out.println(responseContent);
			}

			@Override
			protected synchronized void onResponseContent(Buffer content)
					throws IOException {
				
				System.out.println(content);
			}
		};
		String url1 = "http://10.250.8.214:8080/open/services?sign=06H1rUAzPiBBVkDVko2qug%3D%3D&timestamp=2013-03-07+14%3A30%3A49&session=HM6WYOQQLcoA2%2FBHNX1dnw%3D%3D&zone_id=AT-HOUYIDEV-A&sign_type=MD5&region_id=AT-HOUYIDEV&action=describe_idcisp_data";
		String url2 = "http://localhost:8080/javaweb/chunked";
		exchange.setMethod("GET");
		exchange.setURL(url2);
		
		System.out.println(exchange.getRequestFields());

		// start the exchange
		try {
			Thread.sleep(10 * 1000);
			client.send(exchange);
			
			Thread t = new Thread("Exchange Thread waiting for response"){
				
				public void run() {
					try {
						exchange.waitForDone();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				};
			};
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void test2() {
		HttpClient httpClient = new HttpClient();
		// set up httpClient
		try {
			httpClient.start();
			ContentExchange contentExchange = new ContentExchange(){
				@Override
				protected synchronized void onResponseContent(Buffer content)
						throws IOException {
					System.out.println(content.toString());
				}
				
				@Override
				protected void onRequestComplete() throws IOException {
					// TODO Auto-generated method stub
					System.out.println("request done");
				}
				
				@Override
				protected void onResponseComplete() throws IOException {
					System.out.println("response done");
				}
			};
			httpClient.setConnectorType(HttpClient.CONNECTOR_SELECT_CHANNEL);
			contentExchange.setURL("http://localhost:8080/javaweb/chunked");
			
			httpClient.send(contentExchange);
			contentExchange.waitForDone();
//			System.err.println("Response status: "
//					+ contentExchange.getResponseStatus());
//			System.out.println(contentExchange.getResponseContent());
//			ByteArrayBuffer buffer = new ByteArrayBuffer(1024); 
//
//			while(contentExchange.getRequestContentChunk(buffer) != null){
//				System.out.println(buffer.toString());
//			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
