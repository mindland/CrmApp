package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.java.connection.MysqlConnection;
import com.java.model.User;

public class UserDao {
	
	public List<User> findAll(){
		List<User> models = new LinkedList<User>(); // them xoa dung linked list toc do toi uu 
		try {
			
			Connection connection = MysqlConnection.getConnection(); 
			String query = "SELECT * FROM crm_app.users"; 
		
			PreparedStatement statement = connection.prepareStatement(query); 
		
			ResultSet resultSet = statement.executeQuery(); 
			
			while(resultSet.next()) {
				User model = new User(); 
				model.setId(resultSet.getInt("id"));
				model.setEmail(resultSet.getString("email"));
				model.setPassword(resultSet.getString("password"));
				model.setFullname(resultSet.getString("fullname"));
				model.setAvatar(resultSet.getString("avatar"));
				model.setRole_id(resultSet.getInt("role_id"));
				
				models.add(model); 
			}
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return models;
	}
}
