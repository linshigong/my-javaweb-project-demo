package com.testibatis;

import java.util.List;

public interface IUserDao {

	public User getUserById(String userId);
	
	public Object insertUser(User user);
	
	public List<User> getUserByName(String userName);
}
