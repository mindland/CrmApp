package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.java.connection.JDBCConnection;
import com.java.model.Account;

public class  AccountDao {
	
	public ArrayList<Account> getAll(){
		ArrayList<Account> models = new ArrayList<Account>();
		String query = "SELECT * FROM servlet_crm.accounts"; 
		
		try(Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query); 
			ResultSet res = statement.executeQuery(); 
			
			while(res.next()) {
				Account model = new Account(); 
				model.setId(res.getInt("account_id"));
				model.setFullname(res.getString("fullname"));
				model.setEmail(res.getString("email"));
				model.setPassword(res.getString("password"));
				model.setAddress(res.getString("address"));
				model.setPhone(res.getString("phone"));
				
				models.add(model); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return models; 
	}
}
