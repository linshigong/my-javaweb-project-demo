package test.urlencoder;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class TestUrlEncoder {

	public static void main(String[] args) throws Exception {
		
		String str = "%5B%7B%22protocol%22%3A%22tcp%22%2C%22+frontend_port%22%3A80%2C%22+backend_port%22%3A80%2C%22config%22%3A%7B%22scheduler%22%3A%22rr%22%2C%22persistence_timeout%22%3A1000%2C%22check%22%3A%7B%22type%22%3A%22vtcp%22%7D%7D%2C%7B%22protocol%22%3A%22tcp%22%2C%22frontend_port%22%3A80%2C%22status%22%3A%22inactive%22%2C%22backend_port%22%3A80%2C%22config%22%3A%7B%22scheduler%22%3A%22rr%22%2C%22forwardfor%22%3A%22on%22%2C%22keepalive%22%3A%22on%22%7D%7D%5D%3B";
		
		String str2 = "%5B%7B%22protocol%22%3A%22tcp%22%2C%22frontend_port%22%3A80%2C%22backend_port%22%3A80%2C%22config%22%3A%7B%22scheduler%22%3A%22rr%22%2C%22persistence_timeout%22%3A1000%2C%22check%22%3A%7B%22type%22%3A%22vtcp%22%7D%7D%2C%7B%22protocol%22%3A%22tcp%22%2C%22frontend_port%22%3A80%2C%22status%22%3A%22inactive%22%2C%22backend_port%22%3A80%2C%22config%22%3A%7B%22scheduler%22%3A%22rr%22%2C%22forwardfor%22%3A%22on%22%2C%22keepalive%22%3A%22on%22%7D%7D%5D";
		
		System.out.println(URLDecoder.decode(str2, "utf-8"));
		
		//encoding /r/n
		String uri1 = "A/r/nB";
		System.out.println("original str="+uri1+";after process of urlcode str="+URLEncoder.encode(uri1, "utf-8"));
		
		
	}
	
}
