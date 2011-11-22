package com.testibatis.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.mchange.v2.log.log4j.Log4jMLog;
import com.testibatis.User;
import com.testibatis.dao.IUserDao;

public class UserDaoImpl extends SqlMapClientDaoSupport implements IUserDao {

	public User getUserById(String userId) throws DataAccessException{
		return (User)getSqlMapClientTemplate().queryForObject("selectUserById", userId);
	}

	public List<User> getUserByName(String userName) {
		//
//		Log4jMLog log
		return null;
	}

	public Object insertUser(User user) throws DataAccessException{
		return getSqlMapClientTemplate().insert("insertUser", user);
	}

}
