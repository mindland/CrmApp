package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.RoleDto;
import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;
import com.myclass.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	public void save(RoleDto dto) {
		Role entity = new Role();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDesc());
		
		roleRepository.add(entity);
	}

	public List<RoleDto> getAll() {
		List<Role> entities = roleRepository.findAll();
		
		List<RoleDto> dtos = new ArrayList<RoleDto>();
		for (Role role: entities) {
			dtos.add(new RoleDto(
					role.getId(), 
					role.getName(),
					role.getDescription()));
		}
		return dtos;
	}
	
	public RoleDto findByID(int id) {
		Role role = roleRepository.findById(id); 
		RoleDto dto = new RoleDto(); 
		
		if(role != null) {
			dto.setId(role.getId());
			dto.setName(role.getName());
			dto.setDesc(role.getDescription());
		}
		return dto; 
	}
	
	public void update(RoleDto dto) {
		Role entity = roleRepository.findById(dto.getId()); 
		if(entity != null) {
			entity.setName(dto.getName());
			entity.setDescription(dto.getDesc());
			roleRepository.update(entity);
		}	
	}
	

}
