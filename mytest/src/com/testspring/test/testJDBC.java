package com.testspring.test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driverName);
		
		//
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "system";
		String password = "abc123";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, password);

			// System.out.println(con);
			String sql = "select 1 as name from s_dept";
			String sql2 = "insert into s_dept values(5,'ee',1)";
			stmt = con.createStatement();
			int num = stmt.executeUpdate(sql2);
			System.out.println(num);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt("name"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(con != null){
				con.close();
			}
		}
	}
}
