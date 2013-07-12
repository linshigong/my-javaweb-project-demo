package mytest.dao.impl;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import mytest.dao.UserDao;
import mytest.model.User;

public class UserDaoImpl implements UserDao {

    private SqlMapClientTemplate sqlMapClientTemplate;
    
	public User queryUserById(Long userId) {
		return (User) sqlMapClientTemplate.queryForObject(getStmt("selectUserById"), userId);
	}
	
	private String getStmt(String stamentName){
	    return "user." + stamentName;
	}
	
	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
        this.sqlMapClientTemplate = sqlMapClientTemplate;
    }
}
