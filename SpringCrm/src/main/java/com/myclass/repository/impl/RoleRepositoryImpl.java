package com.myclass.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

	private List<Role> roles = null;
	
	public RoleRepositoryImpl() {
		roles = new ArrayList<Role>();
		roles.add(new Role(1, "ROLE_ADMIN", "Quản trị hệ thống"));
		roles.add(new Role(2, "ROLE_MANAGER", "Quản lý"));
	}

	public void add(Role role) {
		roles.add(role);
	}

	public List<Role> findAll() {
		return roles;
	}
	
	public Role findById(int id) {
		for (Role role : roles) {
			if(id == role.getId())
				return role; 
		}
		return null;  
	}
	
	public void update(Role role) {
		Role roleUpdate = findById(role.getId()); 
		roleUpdate.setName(role.getName());
		roleUpdate.setDescription(role.getDescription());
	}
	
}
