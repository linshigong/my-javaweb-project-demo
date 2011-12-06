package com.test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 读取URL请求返回的数据(xml),比如RSS订阅
 * @author Administrator
 *
 */
public class ReadURLResponse {

	public static void main(String[] args) {
		
			URL url;
			try {
				String urtStr = "http://www.baidu.com";//"http://feed.feedsky.com/jdon"
				
				url = new URL(urtStr);
				URLConnection con = url.openConnection();
				
				StringBuilder builder = new StringBuilder();
				builder.append("info is : ");
				builder.append(con.getContentEncoding()).append("\t");
				builder.append(con.getContentLength()).append("\t");
				builder.append(con.getContentType()).append("\t");
				System.out.println(builder.toString());
				//取的编码格式，需要改进，考虑特殊情况
				String encoddingType = con.getContentType().split("charset=")[1];
				InputStream in = url.openStream();
				
				/* 测试1 读取URL的流，并打印输出 
				BufferedReader reader = new BufferedReader(new InputStreamReader(in,encoddingType));
				String temp = null;
				while((temp = reader.readLine()) != null){ 
					System.out.println(temp);//读一行，输出一行
				}
				*/
				
				/* 测试2 将URL读取的数据保存为文件 */
				int buffer = 10;//设置缓冲大小
				byte[] bs = new byte[buffer];
				File file = new File("d:\\temp.html");
				if(!file.exists()){
					file.createNewFile();
				}
				OutputStream out = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(out);
				while(in.read(bs) != -1){
					bos.write(bs);
				}
				bos.flush();
				
				bos.close();
//				reader.close();
				in.close();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}catch(IOException e2){
				e2.printStackTrace();
			}
			
		
	}
	
	
}
