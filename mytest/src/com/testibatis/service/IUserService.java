package com.testibatis.service;

import java.util.List;

import com.testibatis.User;

public interface IUserService {

	public User getUserById(String userId);
	
	public List<User> getUserByName(String userName);
	
	public Object insertUser(User user);
	
	public Object insertUsers(List<User> userList);
}
