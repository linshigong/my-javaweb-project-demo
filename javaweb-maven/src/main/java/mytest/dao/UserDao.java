package mytest.dao;

import mytest.model.User;

public interface UserDao {

	public User queryUserById(Long userId);
	
}
