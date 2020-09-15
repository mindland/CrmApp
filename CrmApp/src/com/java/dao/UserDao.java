package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.java.connection.MysqlConnection;
import com.java.dto.UserDto;
import com.java.model.User;

public class UserDao {
	
	public List<UserDto> findAll(){
		List<UserDto> models = new LinkedList<UserDto>(); // them xoa dung linked list toc do toi uu 
		try {
			
			Connection connection = MysqlConnection.getConnection(); 
			String query = "SELECT * FROM users as u JOIN roles as r ON u.role_id = r.id"; 
		
			PreparedStatement statement = connection.prepareStatement(query); 
		
			ResultSet resultSet = statement.executeQuery(); 
			
			while(resultSet.next()) {
				UserDto model = new UserDto(); 	
				model.setId(resultSet.getInt("id"));
				model.setEmail(resultSet.getString("email"));
				model.setPassword(resultSet.getString("password"));
				model.setFullname(resultSet.getString("fullname"));
				model.setPhone(resultSet.getString("phone"));
				model.setAddress(resultSet.getString("address"));
				model.setAvatar(resultSet.getString("avatar"));
				model.setRoleName(resultSet.getString("r.name"));
				
				models.add(model); 
			}
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return models;
	}
	
	public int insert(User model) {
		String query =  "INSERT INTO users (email,password,fullname,phone,address,avatar,role_id) VALUES (?,?,?,?,?,?,?)";
		try(Connection connection = MysqlConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setString(1, model.getEmail());
			statement.setString(2, model.getPassword());
			statement.setString(3, model.getFullname());
			statement.setString(4, model.getPhone());
			statement.setString(5, model.getAddress());
			statement.setString(6, model.getAvatar());
			statement.setInt(7, model.getRole_id());
			
			return statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0; 
	}
	
	public int delete(String id) {
		String query =  "DELETE FROM users WHERE id = ?";
		try(Connection connection = MysqlConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setString(1, id);
			
			return statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0; 
	}
	
	public User findById(String id) {
		String query =  "SELECT * FROM users WHERE id = ?";
		try(Connection connection = MysqlConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setString(1, id);
			ResultSet resultSet = statement.executeQuery(); 
			
			while(resultSet.next()) {
				User model = new User(); 
				model.setId(resultSet.getInt("id"));
				model.setEmail(resultSet.getString("email"));
				model.setPassword(resultSet.getString("password"));
				model.setFullname(resultSet.getString("fullname"));
				model.setPhone(resultSet.getString("phone"));
				model.setAddress(resultSet.getString("address"));
				model.setAvatar(resultSet.getString("avatar"));
				model.setRole_id(resultSet.getInt("role_id"));
				
				return model; 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new User() ; 
	}
	
	public int update(User model) {
		String query = "UPDATE users SET email = ? , password = ? , "
				+ "fullname = ? , phone = ?, address = ?, avatar = ?, role_id = ? WHERE id = ?";
		try(Connection connection = MysqlConnection.getConnection()){
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setString(1, model.getEmail());
			statement.setString(2, model.getPassword());
			statement.setString(3, model.getFullname());
			statement.setString(4, model.getPhone());
			statement.setString(5, model.getAddress());
			statement.setString(6, model.getAvatar());
			statement.setInt(7, model.getRole_id());
			statement.setInt(8, model.getId());
			
			return statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0; 
	}
}
