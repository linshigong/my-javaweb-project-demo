package test.zip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 通过GZIPOutputStream、GZIPInputStream和ByteArrayOutputStream、ByteArrayInputStream，测试数据压缩
 * 
 * ByteArrayOutputStream、ByteArrayInputStream作为内存数据流的桥梁
 * 
 * 对汉字等的操作需要显示指定编码，或配置编码环境参数；
 *
 */
public class testGzip {

	public static void main(String[] args) {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		GZIPOutputStream gos = null;
		
		ByteArrayInputStream bais = null;
		GZIPInputStream gis = null;
		
		String v2 = "Hello，你好"; 
		
		try {
			//write
			gos = new GZIPOutputStream(baos);
			gos.write(v2.getBytes("utf-8"),0,v2.getBytes("utf-8").length);
			gos.finish();
			gos.close();
			
			//read compressed content
			byte[] bytes = baos.toByteArray();
			
			
			for(int i=0;i<bytes.length;i++){
				System.out.print(bytes[i]+" ");
			}
			System.out.println(new String(bytes));
			
			//read by uncompressed
			bais = new ByteArrayInputStream(bytes);
			gis = new GZIPInputStream(bais);
			
			byte[] b = new byte[1];
			StringBuilder sb = new StringBuilder();
			ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
			while(gis.read(b) != -1){
				baos2.write(b);
			}
			System.out.println(new String(baos2.toByteArray(),"utf-8"));
			sb.setLength(0);
			
			baos2.close();
			baos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(baos != null){
					baos.close();
				}
				if(baos != null){
					baos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
