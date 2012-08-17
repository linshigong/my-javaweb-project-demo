package test.httprequest;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class test {

	public static void main(String[] args) throws Exception {
		
		String url1 = "http://www.baidu.com/1.swf";
		
		for(int j = 1;j<50;j++){
			
			URL url = new URL(url1+String.valueOf(j));
			//URL url = new URL(url3);
			
			URLConnection con = url.openConnection();
			con.setConnectTimeout(100);
			InputStream in = con.getInputStream();
			if(in != null){
				BufferedInputStream bIn = new BufferedInputStream(in);
				
				
				
				File fOut = new File("d:\\tempbook\\"+j+".swf");
				FileOutputStream fos = new FileOutputStream(fOut);
				
				byte[] bytes = new byte[1024];
				int i = -1;
				while((i = bIn.read(bytes)) != -1){
					fos.write(bytes, 0, i);
				}
				
				fos.close();
				in.close();
				bIn.close();
			}
		}
		
	}
	
}
