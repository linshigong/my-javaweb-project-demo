package com.testibatis;

import java.io.Reader;
import java.io.IOException;
import java.util.List;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.orm.ibatis.SqlMapClientFactoryBean;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

/**
 * This is not a best practices class.  It's just an example
 * to give you an idea of how iBATIS works.  For a more complete
 * example, see JPetStore 5.0 at http://www.ibatis.com.
 */
public class SimpleExample {

  /**
   * SqlMapClient instances are thread safe, so you only need one.
   * In this case, we'll use a static singleton.  So sue me.  ;-)
   */
  private static SqlMapClient sqlMapper;

  /**
   * It's not a good idea to put code that can fail in a class initializer,
   * but for sake of argument, here's how you configure an SQL Map.
   */
  static {
    try {
      Reader reader = Resources.getResourceAsReader("com/testibatis/SqlMapConfig.xml");
      sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
      System.out.println(sqlMapper);
      reader.close(); 
    } catch (IOException e) {
      // Fail fast.
      throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
    }
  }
  
  /**************** test Account *****************/
  
  public static List selectAllAccounts () throws SQLException {
    return sqlMapper.queryForList("selectAllAccounts");
  }

  public static Account selectAccountById  (int id) throws SQLException {
    return (Account) sqlMapper.queryForObject("selectAccountById", id);
  }

  public static void insertAccount (Account account) throws SQLException {
    sqlMapper.insert("insertAccount", account);
  }

  public static void updateAccount (Account account) throws SQLException {
    sqlMapper.update("updateAccount", account);
  }

  public static void deleteAccount (int id) throws SQLException {
    sqlMapper.delete("deleteAccount", id);
  }

  /***************** test User *****************/
  public static void insertUser(User user) throws SQLException{
	  sqlMapper.insert("insertUser", user);
  }
  
  public static User selectUserById(String id) throws SQLException{
	  return (User)sqlMapper.queryForObject("selectUserById", id);
  }
  
  /* test */
  public static void main(String[] args) {
	SimpleExample example = new SimpleExample();
	try {
		//
		//example.insertAccount(new Account(1,"a","Hofstad","123@321.com"));
		//
		//example.insertUser(new User("2","jim",22));
		System.out.println("user is:"+example.selectUserById("1"));
		
	}catch(SQLException sqle){
		System.out.println(sqle);
	} catch (Exception e) {
		System.out.println(e);
	}
	
	//
//	  new org.springframework.orm.ibatis.SqlMapClientFactoryBean().
//	new SqlMapClientFactoryBean()  
  }
  
  
  
}
