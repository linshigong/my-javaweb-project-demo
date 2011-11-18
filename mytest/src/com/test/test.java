package com.test;

public class test {

	
	public static void main(String[] args) {
		
		Integer a = 128;
		Integer b = 128;
		
		Integer c = 127;
		Integer d = 127;
		
		System.out.println((a==b)+" "+a.equals(b));//false true
		/*
		 * Integer在创建对象的时候，如果值小于1b（-128~-127）那么就会将值放入缓冲池，
		 * 下次再创建这个值的Integer对象的时候直接用缓冲池中的这个引用，如果大于1b（-128~-127）
		 * 这个值，则 重新创建新对象。（此处即为：享元模式）
		 */
		System.out.println((c==d)+" "+c.equals(d));//true true
		
	}
}
