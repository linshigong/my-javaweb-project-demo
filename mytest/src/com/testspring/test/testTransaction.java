package com.testspring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.testibatis.IUserService;
import com.testibatis.User;
import com.testibatis.UserServiceImpl;

public class testTransaction {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application-*.xml");
		IUserService userService = (IUserService)context.getBean("userService");
		User user = new User("1","tom",12);
		Object result = userService.insertUser(user);
		System.out.println("insert user ,id="+result);
		
	}
	
}
