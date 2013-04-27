package mytest.dao.impl;

import mytest.base.BaseJtester;
import mytest.dao.UserDao;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.spring.annotation.SpringBeanByName;

public class UserDaoImplTest extends BaseJtester {
	
	@SpringBeanByName
	UserDao userDao;
	
	@Test
	public void testQueryUserById(){
		
		Assert.assertNotNull(userDao);
	}
	
	@Test
	public void test(){
		
		Assert.assertNotNull("");
	}
	
}
