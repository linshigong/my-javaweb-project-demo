package test.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化和反序列化
 * 
 */
public class test {

	public static void main(String[] args) {

		pojo p = new pojo();
		p.setAge(20);
		p.setName("jack");

		String filePath = "d:\\";
		String fileName = "testJava.dat";

		File f = new File(filePath + fileName);
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			//write to file
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(p);

			oos.flush();
			
			//read from file
			f = new File(filePath + fileName);
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			pojo p2 = (pojo)ois.readObject();
			System.out.println(p2);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				fos.close();
				ois.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
