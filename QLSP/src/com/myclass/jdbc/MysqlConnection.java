package com.myclass.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
	private final static String url = "jdbc:mysql://localhost:3306/qlsanpham"; 
	private final static String username = "root"; 
	private final static String password = "phongpham98";	
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			return DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Could not find driver for jdbc connection");
			e.printStackTrace(); // in ra mot stack, khi bi loi se in ra dong bi loi
		}catch (SQLException ex) {
			System.out.println("Could not find database");
			ex.printStackTrace();
		}
		return null; 
	}
			
}
