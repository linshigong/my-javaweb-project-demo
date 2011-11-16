package com.testspring.test;
/**
 * testcxf
 * 
 * @author Administrator
 * Oct 17, 2011
 */
public class Foo {

	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "nams:"+name+" age:"+age;
	}
}
