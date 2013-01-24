package test.concurrent;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class testConcurrent implements Runnable{

	int num;
	int concurrentNum;
	String urlStr;

	public testConcurrent(int num,int concurrentNum,String urlStr){
		this.num = num;
		this.concurrentNum = concurrentNum;
		this.urlStr = urlStr;
	}
	
	public static void main(String[] args) {
		
		testConcurrent test = new testConcurrent(Integer.parseInt(args[0]),Integer.parseInt(args[1]),(String)args[2]);
		
		for(int i=0;i<Integer.parseInt(args[0]);i++){
			Thread t = new Thread(test);
			System.out.println("num="+i+"-------------------------------");
			t.start();
			
		}

	}
	
	@Override
	public void run() {
		try {
			URL url = new URL(urlStr);
			URLConnection conn = url.openConnection();
			conn.connect();
			InputStream in = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(in,Charset.forName("GBK"));
			BufferedReader reader = new BufferedReader(isr);
			
			String str = null;
			while((str = reader.readLine()) != null){
				System.out.println(str);
			}
			reader.close();
			System.out.println("-------------------------------------end of request-----------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setConcurrentNum(int concurrentNum) {
		this.concurrentNum = concurrentNum;
	}

	public void setUrlStr(String urlStr) {
		this.urlStr = urlStr;
	}
	
	
	
}
