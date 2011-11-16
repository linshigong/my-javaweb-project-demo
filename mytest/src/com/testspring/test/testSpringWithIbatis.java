package com.testspring.test;

import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.ibatis.SqlMapClientFactoryBean;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.testibatis.User;

public class testSpringWithIbatis {

	private BasicDataSource dataSource;
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public BasicDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(BasicDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public static void main(String[] args) throws SQLException, InterruptedException, ClassNotFoundException {
		
		//init then get
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		BasicDataSource basicDataSource = (BasicDataSource)context.getBean("dataSource");
		System.out.println("dataSouce :"+context.getBean("dataSource"));
		final SqlMapClient mapClient = (SqlMapClient)context.getBean("sqlMapClient");
		System.out.println("ibatis sqlmapclient :"+mapClient);
		
		
//		user.setName("XiaoT");
//		mapClient.update("updateUser", user);
		
		//test DBCP POOL
		/*
		Class.forName("com.mysql.jdbc.Driver");
		GenericObjectPool connectionPool = new GenericObjectPool(null);
		ConnectionFactory connectionFactory = new DriverManagerConnectionFactory("jdbc:mysql://localhost:3306/mytest", "root", "abc123");
		PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory,connectionPool,null,null,false,true);
		PoolingDataSource dataSource = new PoolingDataSource(connectionPool);
		*/
//		dataSource.
		
//		mapClient.setUserConnection(dataSource.getConnection());
		
//		new SqlMapClientBuilder();
		
		Thread t = new Thread(){
			@Override
			public void run() {
				while(true){
					try {
						User user = (User)mapClient.queryForObject("selectUserById","1");
						System.out.println("Thread 1 result: "+user);
						Thread.currentThread().sleep(6*1000);
//						mapClient.getCurrentConnection().close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread t2 = new Thread(){
			@Override
			public void run() {
				while(true){
					try {
						User user = (User)mapClient.queryForObject("selectUserById","1");
						System.out.println("Thread 2 result: "+user);
//						mapClient.getCurrentConnection().close();
						Thread.currentThread().sleep(6*1000);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		new PoolingDataSource();
		t.start();
		t2.start();
	}
}
