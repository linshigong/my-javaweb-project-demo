package com.testibatis.service;

import java.util.List;

import com.testibatis.User;

public interface IUserService {

	public User getUserById(String userId);
	
	public List<User> getUserByName(String userName);
	
	public Object insertUser(User user);
	
	/**
	 * 同时保存多个User
	 * @param userList 将被保存的多个User
	 * @return 是否同时保存成功,否则都不保存
	 */
	public boolean insertUsers(List<User> userList);
}
