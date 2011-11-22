package com.testibatis.dao;

import java.util.List;

import com.testibatis.User;

public interface IUserDao {

	public User getUserById(String userId);
	
	public Object insertUser(User user);
	
	public List<User> getUserByName(String userName);
}
