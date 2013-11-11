package test.httpclient.jettyhttpclient;

import java.io.IOException;

import org.eclipse.jetty.client.ContentExchange;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

public class JettyHttpClient2 {
	public static void main(String[] args) {

		HttpClient client = new HttpClient();
		client.setConnectorType(HttpClient.CONNECTOR_SELECT_CHANNEL);
		
		client.setConnectTimeout(5 * 1000);
		client.setIdleTimeout(1000 * 60 * 60);//1小时连接未用则超时释放
		client.setMaxConnectionsPerAddress(10240);
		client.setMaxQueueSizePerAddress(10240);
		
		QueuedThreadPool pool = new QueuedThreadPool();
		pool.setMaxThreads(10);//这里值不能小于2，待分析原因
		pool.setDaemon(true);
		pool.setName("JettyHttpClient");
		
		client.setThreadPool(pool);
		
		client.setConnectBlocking(false);//此属性的设置影响内容如注释中说明
		
		//
		try {
			client.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

		ContentExchange exchange = new ContentExchange() {
			protected void onResponseComplete() throws IOException {
				super.onRequestComplete();
				String responseContent = this.getResponseContent();
				System.out.println(responseContent);
			}
		};

		exchange.setMethod("GET");
		exchange.setURL("http://www.baidu.com/");

		// start the exchange
		try {
			client.send(exchange);
			exchange.waitForDone();
		} catch (IOException e) {
			e.printStackTrace();
		}  catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

