package com.java.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	public static Connection getConnection() {
		final String database = "jdbc:mysql://localhost:3306/servlet_crm";
		final String username = "root"; 
		final String password = "phongpham98"; 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			return DriverManager.getConnection(database, username, password); 
		} 
		catch (ClassNotFoundException e) {
			System.out.println("Could not find driver for jdbc connection");
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println("Could not find database");
			e.printStackTrace();
		}
		
		return null;
	}
}
