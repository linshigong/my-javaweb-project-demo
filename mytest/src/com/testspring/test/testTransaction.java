package com.testspring.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import com.testibatis.User;
import com.testibatis.service.IUserService;
import com.testibatis.service.impl.UserServiceImpl;

public class testTransaction {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application-*.xml");
		
		/* test tx方式事务 
		IUserService userService = (IUserService)context.getBean("userService");
		User user = new User("1","tom",12);
		Object result = userService.insertUser(user);
		System.out.println("insert user ,id="+result);
		*/
		
		/* test 每个Bean都有一个代理方式事务,注意getBean时取的是代理类，不是原来的类 
		IUserService userService = (IUserService)context.getBean("userServiceProxy");
		User user1 = new User("100","Jack",16);//can save to DB
		User user2 = new User(null,"tom",12);//can't save to DB
		List<User> userList = new ArrayList<User>();
		userList.add(user1);
		userList.add(user2);
		boolean result = userService.insertUsers(userList);
		System.out.println("insert user ,result is :"+result);
		*/
		
		/* test 所有bean共享一个代理方式 
		IUserService userService = (IUserService)context.getBean("userServiceProxy2");
		User user1 = new User("100","Jack",16);//can save to DB
		User user2 = new User(null,"tom",12);//can't save to DB
		List<User> userList = new ArrayList<User>();
		userList.add(user1);
		userList.add(user2);
		boolean result = userService.insertUsers(userList);
		System.out.println("insert user ,result is :"+result);
		*/
		
		/* 拦截器方式 *ServiceImpl 匹配的bean都对方法加上事务 ；测试时，注意先把tx方式匹配参数修改，否则影响结果*/
		IUserService userService = (IUserService)context.getBean("userService");
		User user1 = new User("100","Jack",16);//can save to DB
		User user2 = new User(null,"tom",12);//can't save to DB
		List<User> userList = new ArrayList<User>();
		userList.add(user1);
		userList.add(user2);
		boolean result = userService.insertUsers(userList);
		System.out.println("insert user ,result is :"+result);
	}
	
}
