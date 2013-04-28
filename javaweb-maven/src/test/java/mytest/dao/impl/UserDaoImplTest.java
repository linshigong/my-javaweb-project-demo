package mytest.dao.impl;

import mytest.dao.UserDao;
import mytest.model.User;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.spring.annotation.SpringBeanByName;

import base.BaseJtester;

public class UserDaoImplTest extends BaseJtester {
	
	@SpringBeanByName
	UserDao userDao;
	
//	static{
//		new ClassPathXmlApplicationContext("spring\\application-context.xml");
//	}
	
	@Test
	public void testQueryUserById(){
		
		User user = userDao.queryUserById(1L);
		
		Assert.assertNotNull(user);
	}
	
	@Test
	public void test(){
		
		Assert.assertNotNull("");
	}
	
}
