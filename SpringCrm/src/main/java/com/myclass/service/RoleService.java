package com.myclass.service;

import java.util.List;

import com.myclass.dto.RoleDto;

public interface RoleService {
	void save(RoleDto dto);
	List<RoleDto> getAll();
	RoleDto findByID(int id);
	void update(RoleDto dto); 
}
