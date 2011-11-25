package com.testibatis.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.testibatis.User;
import com.testibatis.dao.BaseDao;
import com.testibatis.dao.IUserDao;

public class UserDaoImpl extends BaseDao implements IUserDao {

	public User getUserById(String userId) throws DataAccessException{
		return (User)getSqlMapClientTemplate().queryForObject("selectUserById", userId);
	}

	public List<User> getUserByName(String userName) {
		return null;
	}

	public Object insertUser(User user) throws DataAccessException{
		return getSqlMapClientTemplate().insert("insertUser", user);
	}

}
