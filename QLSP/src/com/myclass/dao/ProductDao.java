package com.myclass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.myclass.entity.Products;
import com.myclass.jdbc.MysqlConnection;

public class ProductDao {
	
	public List<Products> findAll(){
		List<Products> listProducts = new LinkedList<Products>(); 
		
		try {
			Connection connection = MysqlConnection.getConnection(); 
			String query = "SELECT * FROM products"; 
			
			PreparedStatement statement = connection.prepareStatement(query); 
			ResultSet resultSet = statement.executeQuery(); 
			
			while(resultSet.next()) {
				Products product = new Products(); 
				product.setId(resultSet.getString("id"));
				product.setCateId(resultSet.getString("cateId"));
				product.setName(resultSet.getString("name"));
				product.setAmount(resultSet.getInt("amount"));
				product.setPrice(resultSet.getFloat("price"));
				listProducts.add(product);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listProducts;
	}

	public Products findById(String id) {
		List<Products> listProducts = new LinkedList<Products>(); 
		
		try {
			Connection connection = MysqlConnection.getConnection(); 
			String query = "SELECT * FROM products WHERE id = ?"; 
			
			PreparedStatement statement = connection.prepareStatement(query); 
			
			statement.setString(1, id);
			
			ResultSet resultSet = statement.executeQuery(); 
			
			while(resultSet.next()) {
				Products product = new Products(); 
				product.setId(resultSet.getString("id"));
				product.setName(resultSet.getString("name"));
				product.setAmount(resultSet.getInt("amount"));
				product.setPrice(resultSet.getFloat("price"));
				product.setCateId(resultSet.getString("cateId"));
				
				return product; 
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new Products();
	}
	
	public void delete(String id) {
		 try {
				Connection connection = MysqlConnection.getConnection(); 
				String query = "DELETE FROM products" + " WHERE id = ?"; 

				PreparedStatement statement = connection.prepareStatement(query);  // luu san duoi db
				
				statement.setString(1, id); 
				
				if(statement.executeUpdate() > 0) {
					System.out.println("Xoa thanh cong!");
				}
							
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void insert(Products product) {
		try {
			Products existProduct = findById(product.getId()); 
			if(!existProduct.getId().equals("")) {
				System.out.println("Product with id [" + product.getId() + "] is existed.");
				return;
			}
			
			Connection connection = MysqlConnection.getConnection();
			String query = "INSERT INTO products" + 
							" VALUES(?, ?, ?, ?, ?)";
			
			// tao 1 cai statement de truy van
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, product.getId());
			statement.setString(2, product.getName()); 
			statement.setInt(3, product.getAmount());
			statement.setFloat(4, product.getPrice());
			statement.setString(5, product.getCateId()); 
			
			if(statement.executeUpdate() > 0) {
				System.out.println("Insert product id [" + product.getId() + "] successfully");
			} else 
				System.out.println("Failed to insert product id [" + product.getId() + "].");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Products product) {
		try {
			Connection connection = MysqlConnection.getConnection(); 
			String query = "UPDATE products SET cateId = ? , name = ?, amount = ?, price = ? WHERE id = ?"; 
			
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setString(1, product.getCateId()); 
			statement.setString(2, product.getName()); 
			statement.setInt(3, product.getAmount());
			statement.setFloat(4, product.getPrice());
			statement.setString(5, product.getId());
			
			if(statement.executeUpdate() > 0) {
				System.out.println("Update thanh cong!");
			}

			} catch (Exception e) {
				e.printStackTrace();
				}
		}
}
