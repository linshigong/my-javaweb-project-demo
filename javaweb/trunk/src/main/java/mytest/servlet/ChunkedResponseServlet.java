package mytest.servlet;

import java.io.IOException;
import java.io.OutputStream;

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
	 private static final byte ZERO[] = new byte[] {(byte) '0'};

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		
		resp.setHeader("Pragma", "No-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);
		
		resp.setHeader("Transfer-Encoding", "chunked");
		
		OutputStream out = resp.getOutputStream();//与使用write的区别，少了流转换的开销？但不能利用buffer的好处
		String trunk1 = "chunk1AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		String trunk2 = "chunk2";
		//size of first chunk
		out.write(Integer.toHexString(trunk1.length()*2).getBytes());
		out.write(CRLF);
		//send first chunk
		out.write(trunk1.getBytes());
		out.write(trunk1.getBytes());
		out.write(CRLF);
		//size of second chunk
		out.write(Integer.toHexString(trunk2.length()).getBytes());
		out.write(CRLF);
		//send second chunk
		out.write(trunk2.getBytes());
		out.write(CRLF);
		//send chunked data end flag
		out.write(ZERO);
		out.write(CRLF);
		//send CRLF
		out.write(CRLF);
	}

	@Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	 throws ServletException, IOException {
	 super.doGet(req, resp);
	 }

}
