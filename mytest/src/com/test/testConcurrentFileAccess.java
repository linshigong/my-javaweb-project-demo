package com.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Properties;

/**
 * 测试进程并发操作同一文件，保证并发正常
 * 
 * 方式一：
 * 		* 通过java io api提供的文件锁实现
 * 		* 如果是异构的系统调用，也应该实现文件锁控制，并在写入前判断是否
 * 		  能进行写操作。
 * @author Administrator
 *
 */
public class testConcurrentFileAccess {

	public static void main(String[] args) {
		
		File f = new File("d:\\bak.txt");
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try{
			if(f.canWrite()){
				f.setWritable(true,true);
			}
			br = new BufferedReader(new FileReader(f));
			String temp = null;
			System.out.println(temp = br.readLine());
			
			bw = new BufferedWriter(new FileWriter(f));
			bw.write("new"+(temp == null?"":temp));
			f.setWritable(true);
			bw.flush();
		}catch(FileNotFoundException e){
			System.out.println("文件未找到");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("文件操作异常");
			e.printStackTrace();
		}finally{
			try {
				if(br != null){
					br.close();
				}
				if(bw != null){
					bw.close();
				}
			} catch (IOException e) {
				System.out.println("文件关闭错误");
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 对于用 Properties 类操作的文件，可以通过load方法锁定流，再操作
	 */
	public void testPropertiesFile(){
		Properties pro = new Properties();
		
		File f = null;
		FileInputStream fis = null;
		
		
		try {
			f = new File("d:\\bak.txt");
			if(f.exists() && f.canWrite()){
				f.setWritable(true, true);
			}
			
			fis = new FileInputStream(f);
			pro.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
