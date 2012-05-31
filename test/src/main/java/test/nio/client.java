package test.nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 多个线程去并发访问server
 */
public class client {

	public static void main(String[] args) {
		
		Thread t = new Thread(){
			public void run() {
				
				try {
					Socket s = new Socket("localhost", 55555);
					InputStream in = s.getInputStream();
					System.out.println(in);
					InputStreamReader inReader = new InputStreamReader(in);
					int i = -1;
					while((i = inReader.read()) != -1){
						System.out.println(i);
					}
					s.getOutputStream().write(1);
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			};
		};
		
		t.start();
	}
	
}
