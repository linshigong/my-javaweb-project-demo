package com.testibatis;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;

import common.Logger;

public class UserServiceImpl implements IUserService {

	Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	private IUserDao userDao;
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public User getUserById(String userId) {
		User user = null;
		try {
			user = userDao.getUserById(userId);	
		} catch (DataAccessException e) {
			logger.debug("数据访问错误:"+e);
		}
		//do something else here
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
		}
		
		//do something else
		return result;
	}

	public Object insertUsers(List<User> userList) {
		// TODO Auto-generated method stub
		return null;
	}

}
