package mytest.servlet;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 返回chunked数据
 * 根据协议要求：
 */
public class ChunkedResponseServlet extends HttpServlet {

	private static final long serialVersionUID = -4486688450887394215L;

	private static final byte CRLF[] = new byte[] { (byte) 13, (byte) 10 };
	private static final byte ZERO[] = new byte[] { (byte) '0' };

	private final static String CRLF2 = "\r\n";
	private final static String ZERO2 = Integer.toHexString(0);

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setHeader("Pragma", "No-cache");
		resp.setHeader("Cache-Control", "no-cache");
//		resp.setHeader("Content-Type", "text/plain");
		resp.setDateHeader("Expires", 0);
		
		resp.setHeader("Transfer-Encoding", "chunked");//设置Chunked标识
		resp.setHeader("X-Accel-Buffering", "no");
		
		String trunk1 = "chunk11";
		String trunk2 = "chunk22";
		
		/* 1) Write by byte  */
		BufferedOutputStream out = new BufferedOutputStream(resp.getOutputStream());
		//size of first chunk
		String header = Integer.toHexString(trunk1.length());
		out.write(header.getBytes());
		out.write(CRLF);
		//send first chunk
		out.write(trunk1.getBytes());
		out.write(CRLF);
		out.flush();
		sleep();
		//size of second chunk
		out.write(Integer.toHexString(trunk2.length()).getBytes());
		out.write(CRLF);
		//send second chunk
		out.write(trunk2.getBytes());
		out.write(CRLF);
		out.flush();
		sleep();
		//send chunked data end flag
		out.write(ZERO);
		out.write(CRLF);
		//send CRLF
//		out.write(CRLF);
		
		out.flush();
		out.close();
		
		
		/* 2) Write by String ,写好一个chunk需要flush下 ，outputstream和writer两者输出效果一样
		BufferedWriter writer = new BufferedWriter(resp.getWriter());
		
		//size of first chunk
		writer.write(Integer.toHexString(trunk1.length()+2));
		writer.write(CRLF2);
		//send first chunk
		writer.write(trunk1);
		writer.flush();
		sleep();
		//size of second chunk
		writer.write(Integer.toHexString(trunk2.length()));
		writer.write(CRLF2);
		//send second chunk
		writer.write(trunk2);
		writer.flush();
		sleep();
		//send chunked data end flag
		writer.write(Integer.toBinaryString(0));
		writer.write(CRLF2);
		writer.flush();
		*/
		
	}

	@Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	 throws ServletException, IOException {
	 super.doGet(req, resp);
	 }

	private void sleep(){
		try {
			Thread.sleep(2 * 1000);//sleep 5 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
