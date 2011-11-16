package com.testDBCP;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

public class testDBCP {

	
	public static void main(String[] args) {
		GenericObjectPool connectionPool = new GenericObjectPool(null);
		ConnectionFactory connectionFactory = new DriverManagerConnectionFactory("jdbc:mysql://localhost:3306/mytest", "root", "abc123");
		PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory,connectionPool,null,null,false,true);
		PoolingDataSource dataSource = new PoolingDataSource(connectionPool);
		
		System.out.println(dataSource);
	}
}
