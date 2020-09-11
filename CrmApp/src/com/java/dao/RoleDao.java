package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.java.connection.MysqlConnection;
import com.java.model.Role;


public class RoleDao {
	public List<Role> findAll(){
		List<Role> models = new LinkedList<Role>();
		try {
			
			Connection connection = MysqlConnection.getConnection(); 
			String query = "SELECT * FROM crm_app.Roles"; 
		
			PreparedStatement statement = connection.prepareStatement(query); 
		
			ResultSet resultSet = statement.executeQuery(); 
			
			while(resultSet.next()) {
				Role model = new Role(); 
				model.setId(resultSet.getInt("id"));
				model.setName(resultSet.getString("name"));
				model.setDescription(resultSet.getString("description"));
				
				models.add(model); 
			}
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return models;
	}
}