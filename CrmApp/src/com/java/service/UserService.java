package com.java.service;

import java.util.List;

import com.java.dao.UserDao;
import com.java.dto.UserDto;
import com.java.model.User;

public class UserService {
	
	private UserDao userDao = null; 
//	private RoleDao roleDao = null; 
	
	public UserService() {
		userDao = new UserDao(); 
//		roleDao = new RoleDao(); 
	}
	
	public List<UserDto> findAll(){
		List<UserDto> dtos = userDao.findAll(); 
		
		return dtos; 
	}
	
	public UserDto findById(String id) {
		UserDto dto = userDao.findById(id); 		
		
		return dto; 
	}
	
	public void delete(String id) {
		userDao.delete(id);
	}
	
	public void insert(UserDto dto) {
		User user = new User(); 
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setFullname(dto.getFullname());
		user.setPhone(dto.getPhone());
		user.setAddress(dto.getAddress());
		user.setAvatar(dto.getAvatar());
		user.setRole_id(dto.getRole_id());
		
		userDao.insert(user);
	}
	
	public void update(UserDto dto) {
		User user = new User(); 
		
		user.setId(dto.getId());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setFullname(dto.getFullname());
		user.setPhone(dto.getPhone());
		user.setAddress(dto.getAddress());
		user.setAvatar(dto.getAvatar());
		user.setRole_id(dto.getRole_id());
		
		userDao.update(user);
	}
}
