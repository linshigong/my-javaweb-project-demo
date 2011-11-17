package com.testibatis;

import java.util.List;

public interface IUserService {

	public User getUserById(String userId);
	
	public List<User> getUserByName(String userName);
	
	public Object insertUser(User user);
	
	public Object insertUsers(List<User> userList);
}
