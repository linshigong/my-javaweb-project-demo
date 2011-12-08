package com.test;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class testJNDIDataSource {

	public static void main(String[] args) {
		DataSource dataSource = null;
		try {
        	dataSource = (DataSource)InitialContext.doLookup("java:comp/env/jdbc/mytest");
        	System.out.println(dataSource);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
}
