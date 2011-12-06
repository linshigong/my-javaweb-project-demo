package com.testibatis.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.util.StringUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.testibatis.User;
import com.testibatis.dao.IUserDao;
import com.testibatis.service.IUserService;

import common.Logger;

public class UserServiceImpl implements IUserService {

	protected final Logger logger = Logger.getLogger(getClass());
	
	private IUserDao userDao;
	
	/** 细节：对于service层，这个get方法不需要提供，可以删除 
	public IUserDao getUserDao() {
		return userDao;
	}
	*/
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public User getUserById(String userId) {
		User user = null;
		try {
			user = userDao.getUserById(userId);	
		} catch (DataAccessException e) {
			logger.debug("数据访问错误:"+e);
		}catch(Exception e){
			System.out.println("出现错误");
		}
		//do something else here
		//...
		return user;
	}

	public List<User> getUserByName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object insertUser(User user) {
		Object result = null;
		try {
			result = userDao.insertUser(user);
		} catch (Exception e) {
			logger.debug("数据访问错误"+e);
			throw (DataAccessException)e;
		}
		//do something else
		//...
		return result;
	}
	
	public boolean insertUsers(List<User> userList) {
		Object result = null;
		for (User user : userList) {
			result = userDao.insertUser(user);
		}
		return result == null?false:true;
	}

}
