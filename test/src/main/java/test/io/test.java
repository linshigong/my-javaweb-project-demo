package test.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class test {

	public static void main(String[] args) {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			baos.write("hello".getBytes());
			baos.close();
			
			System.out.println(new String(baos.toByteArray()));//hello
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
