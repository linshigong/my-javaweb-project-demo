package com.testspring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoaderListener;

/**
 * testcxf
 * ������
 * @author Administrator
 * Oct 17, 2011
 */
public class test {

	private static Foo foo;
	private String testName;
	
	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Foo getFoo() {
		return foo;
	}

	public void setFoo(Foo foo) {
		this.foo = foo;
	}

	public static void main(String[] args) {
		
		//spring自动装配
		System.out.println(foo);
		
		//test spring's IOC/DI ;first do initial then get bean
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		System.out.println(context);
		System.out.println(context.getBean("foo"));
		
		System.out.println(foo);
		
	}
	
	@Override
	public String toString() {
		return foo.toString()+""+getTestName();
	}
}
