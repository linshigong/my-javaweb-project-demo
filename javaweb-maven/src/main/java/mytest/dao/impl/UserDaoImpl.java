package mytest.dao.impl;

import mytest.dao.UserDao;
import mytest.model.User;

import org.hibernate.SessionFactory;

public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;
	
	public User queryUserById(Long userId) {
	
		sessionFactory.getCurrentSession().createSQLQuery("select * from user");
		return new User();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
