package test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Driver;

public class test {

	public static void main(String[] args) throws Exception {
		
		String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://10.230.130.1/xuanyuan_monitor?useUnicode=true&amp;characterEncoding=utf-8";
		String userName = "root";
		String pwd = "654123";
		
		DriverManager.registerDriver(new Driver());
		//Class.forName(className);
		
		Connection con = DriverManager.getConnection(url, userName, pwd);
		
		System.out.println(con);//com.mysql.jdbc.JDBC4Connection@55571e
		
		
		//another con
		/*
		db.source.driver=com.mysql.jdbc.Driver
				db.source.url=jdbc:mysql://10.250.8.214/slbapi?useUnicode=true&amp;characterEncoding=utf-8
				db.source.username=test
				db.source.password=test
				db.source.min.idle=5
				db.source.max.active=10
				db.source.max.idle=10
		*/
		DriverManager.registerDriver(new Driver());
		Connection con2 = DriverManager.getConnection("jdbc:mysql://10.250.8.214/slbapi?useUnicode=true&amp;characterEncoding=utf-8", 
				"test", "test");
		System.out.println(con2);
	}
	
}
