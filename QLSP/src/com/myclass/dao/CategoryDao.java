package com.myclass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.myclass.entity.Category;
import com.myclass.jdbc.MysqlConnection;


public class CategoryDao {
	
	public List<Category> findAll(){
		List<Category> listCategory = new LinkedList<Category>(); // them xoa dung linked list toc do toi uu 
		try {
			// tao 1 connection den database 
			Connection connection = MysqlConnection.getConnection(); 
			String query = "SELECT * FROM categories"; 
			// tao 1 cai stament de truy van 
			PreparedStatement statement = connection.prepareStatement(query);  // luu san duoi db
			// ibatis MyBatis3
			// thuc hien truy van va lay ve ket qua(ResultSet)
			ResultSet resultSet = statement.executeQuery(); // cong ty lon viet jdbc thuan
			// resultset la 1 linked list
			
			while(resultSet.next()) {
				Category result = new Category(); 
				result.setId(resultSet.getString("id"));
				result.setName(resultSet.getString("name"));
				result.setDescription(resultSet.getString("description"));
				listCategory.add(result);
			}
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listCategory;
	}
	
	public Category findById(String id) {
		List<Category> listCategory = new LinkedList<Category>(); // them xoa dung linked list toc do toi uu 
		try {
			// tao 1 connection den database 
			Connection connection = MysqlConnection.getConnection(); 
			String query = "SELECT * FROM categories WHERE id = ?"; 
			// tao 1 cai stament de truy van 
			PreparedStatement statement = connection.prepareStatement(query);  // luu san duoi db
			
			statement.setString(1, id);  // 1 la STT cua dau ?
			
			// thuc hien truy van va lay ve ket qua(ResultSet)
			ResultSet resultSet = statement.executeQuery(); // cong ty lon viet jdbc thuan
			// resultset la 1 linked list
			
			while(resultSet.next()) {
				// parse resultset to category model 
				Category result = new Category(); 
				result.setId(resultSet.getString("id"));
				result.setName(resultSet.getString("name"));
				result.setDescription(resultSet.getString("description"));
				
				return result; 
			}
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new Category(); 
	}
	
	public void delete(String id) {
		 try {
			Connection connection = MysqlConnection.getConnection(); 
			String query = "DELETE FROM categories" + " WHERE id = ?"; 

			PreparedStatement statement = connection.prepareStatement(query);  // luu san duoi db
			
			statement.setString(1, id); 
			
			if(statement.executeUpdate() > 0) {
				System.out.println("Xoa thanh cong!");
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insert(Category category) {
		try {
			// kiem tra xem category da ton tai hay chua
			Category existedCategory = findById(category.getId());
			if(!"".equals(existedCategory.getId())) {
				System.out.println("Category with id [" + category.getId() + "] is existed.");
				return;
			}
			
			// tao 1 connection den database
			Connection connection = MysqlConnection.getConnection();
			String query = "INSERT INTO categories" + 
							" VALUES(?, ?, ?)";
			
			// tao 1 cai statement de truy van
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, category.getId());
			statement.setString(2, category.getName());
			statement.setString(3, category.getDescription());
			
			if(statement.executeUpdate() > 0) {
				System.out.println("Insert category id [" + category.getId() + "] successfully");
			} else 
				System.out.println("Failed to insert category id [" + category.getId() + "].");
		} catch (Exception e) {
			// TODO: print stack trace
			e.printStackTrace();
		}
	}
	
	public void update(Category cat) {
		try {
			// tao 1 connection den database 
			Connection connection = MysqlConnection.getConnection(); 
			String query = "UPDATE categories SET name = ? , description = ? Where id = ?  "; 
			// tao 1 cai stament de truy van 
			PreparedStatement statement = connection.prepareStatement(query);  // luu san duoi db
			
			statement.setString(1, cat.getName()); 
			statement.setString(2, cat.getDescription()); 
			statement.setString(3, cat.getId()); 
			
			if(statement.executeUpdate() > 0) {
				System.out.println("Update thanh cong!");
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

