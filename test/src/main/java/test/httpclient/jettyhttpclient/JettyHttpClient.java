package test.httpclient.jettyhttpclient;

import java.io.IOException;

import org.eclipse.jetty.client.ContentExchange;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

public class JettyHttpClient {

	public static void main(String[] args) {
		HttpClient client = new HttpClient();
		client.setConnectorType(HttpClient.CONNECTOR_SELECT_CHANNEL);
		client.setConnectTimeout(5 * 1000);
		client.setIdleTimeout(1000 * 60 * 60);//1小时连接未用则超时释放
		client.setMaxConnectionsPerAddress(10240);
		client.setMaxQueueSizePerAddress(10240);
		
		QueuedThreadPool pool = new QueuedThreadPool();
		pool.setMaxThreads(Runtime.getRuntime().availableProcessors());
		pool.setDaemon(true);
		pool.setName("JettyHttpClient");
		
		client.setThreadPool(pool);
		
		/*
		 	if (_httpClient.isConnectBlocking())
            {
                channel.socket().connect(address.toSocketAddress(), _httpClient.getConnectTimeout());
                channel.configureBlocking(false);
                _selectorManager.register( channel, destination );
            }
            else
            {
                channel.configureBlocking(false);
                channel.connect(address.toSocketAddress());
                _selectorManager.register(channel,destination);
                ConnectTimeout connectTimeout = new ConnectTimeout(channel,destination);
                _httpClient.schedule(connectTimeout,_httpClient.getConnectTimeout());
                _connectingChannels.put(channel,connectTimeout);
            }
            
            PS:	connectBlocking 设置为true时，socket建立连接会阻塞，直到连接建立或其他异常发生才返回；
              	设置为false时，直接返回并,应用需要自己设置连接超时时间，以及异步结果的返回
		 */
		client.setConnectBlocking(false);//此属性的设置影响内容如注释中说明
		try {
			client.start();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		ContentExchange exchange = new ContentExchange();
		String url = "93.46.8.89";//93.46.8.89 facebook ^^
		String url2 = "10.250.8.214";
		exchange.setURL("http://"+url2);
		
		String response = null;
		try {
			client.send(exchange);
			Thread.sleep(60 * 1000);
			exchange.waitForDone();
			response = exchange.getResponseContent();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(response);
		
	}
	
}
