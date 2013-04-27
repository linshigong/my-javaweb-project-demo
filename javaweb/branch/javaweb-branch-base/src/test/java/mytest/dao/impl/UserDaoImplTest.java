package mytest.dao.impl;

import mytest.base.BaseJtester;
import mytest.dao.UserDao;
import mytest.model.User;

import org.jtester.unitils.dbfit.DbFit;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.spring.annotation.SpringBeanByName;

public class UserDaoImplTest extends BaseJtester {
	
	@SpringBeanByName
	UserDao userDao;
	
	@DbFit(when={"UserDaoImplTest.queryUserById.when.wiki"})
	@Test
	public void testQueryUserById(){
		User user = userDao.queryUserById(1001L);
		
		Assert.assertNotNull(user);
	}
	
}
