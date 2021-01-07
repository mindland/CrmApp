package com.myclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myclass.dto.RoleDto;
import com.myclass.service.RoleService;

@Controller
@RequestMapping("role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = {""}, method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<RoleDto> dtos = roleService.getAll();
		model.addAttribute("roles", dtos);
		return "role/index";
	}
	
	@RequestMapping(value = {"add"}, method = RequestMethod.GET)
	public String add(ModelMap model) {
		// tạo đối tượng rỗng(không có dữ LIỆ U)
		RoleDto dto = new RoleDto()	; 
		// truyền đối tượng vừa tạo qua trang add.html
		model.addAttribute("role", dto); 
		
		return "role/add";
	}
	
	@RequestMapping(value = {"add"}, method = RequestMethod.POST)
	public String add(@ModelAttribute("role") RoleDto dto) {
		roleService.save(dto);
		return "redirect:/role";
	}
	
	@RequestMapping(value = {"edit"}, method = RequestMethod.GET)
	public String edit(@RequestParam("id") int id , ModelMap model) {
		RoleDto dto = roleService.findByID(id); 	
		model.addAttribute("role", dto); 
		return "role/edit";
	}
	
	@RequestMapping(value = {"edit"}, method = RequestMethod.POST)
	public String edit(@ModelAttribute("role") RoleDto dto) {
		roleService.update(dto);
		return "redirect:/role";
	}
	
}

