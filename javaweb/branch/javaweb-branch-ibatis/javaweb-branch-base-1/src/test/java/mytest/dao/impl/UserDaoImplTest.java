package mytest.dao.impl;

import javax.sql.DataSource;

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
	
	@SpringBeanByName
	DataSource dataSource;
	
	@DbFit(when={"UserDaoImplTest.testQueryUserById.then.wiki"})
	@Test
	public void testQueryUserById(){
	    User actual = userDao.queryUserById(222L);
	    
		Assert.assertNotNull(actual);
	}
	
}
