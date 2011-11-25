package com.testibatis.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.testibatis.User;

public interface IUserDao {

	public User getUserById(String userId);
	
	/**
	 * Save user
	 * @param user the user pojo to save
	 * @return a result object returned by the action, or null
	 */
	public Object insertUser(User user) throws DataAccessException;
	
	/**
	 * Get users by name,may be more than one user
	 * @param userName
	 * @return 
	 */
	public List<User> getUserByName(String userName);
}
