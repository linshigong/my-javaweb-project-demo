package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class testIO {
	
	public static void main(String[] args) {
		//测试IO流，关闭缓冲流后，是否也连带关闭套接它的基础流
		InputStream inputStream = null;
		BufferedReader bufReader = null;
		try {
			inputStream= new FileInputStream("d:\\cmd.txt");
			bufReader = new BufferedReader(new InputStreamReader(inputStream));
			System.out.println(bufReader.readLine());
		} catch (Exception e) {
			System.out.println("读取文件错误");
			e.printStackTrace();
		}finally{
			try {
				
				System.out.println(inputStream.read());
				bufReader.close();
			} catch (IOException e) {
				System.out.println("关闭流出错");
				e.printStackTrace();
			}
//			try {
//				System.out.println(inputStream.available());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}	
	}
	
}
