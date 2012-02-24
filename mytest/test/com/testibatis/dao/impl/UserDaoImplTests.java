package com.testibatis.dao.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.testibatis.dao.IUserDao;

import junit.framework.TestCase;

public class UserDaoImplTests extends TestCase {

	private IUserDao userDao;

	@Override
	protected void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-*.xml");
		userDao = (IUserDao) context.getBean("userDao");
	}

	public void testGetAndSetUser(){
		assertNull(userDao.getUserById(""));
	}
	
}
