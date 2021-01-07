package com.myclass.repository;

import java.util.List;

import com.myclass.entity.Role;

public interface RoleRepository {
	void add(Role role);
	List<Role> findAll();
	Role findById(int id); 
	void update(Role role); 
}
