package com.java.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dto.RoleDto;
import com.java.service.RoleService;


@WebServlet(urlPatterns = {"/role", "/role/add", "/role/delete", "/role/edit"})
public class RoleController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private RoleService roleService = null; 
	
	@Override
	public void init() throws ServletException {
		roleService = new RoleService(); 
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getServletPath(); 
		switch (action) {
		case "/role": 
			req.setAttribute("roles", roleService.findAll());
			req.getRequestDispatcher("/WEB-INF/views/role/index.jsp").forward(req, resp);
			break;
		case "/role/add": 
			req.getRequestDispatcher("/WEB-INF/views/role/add.jsp").forward(req, resp);
			break;
		case "/role/edit": 
			String idEdit =  req.getParameter("id");
			RoleDto model = roleService.findById(idEdit); 
			req.setAttribute("role", model);
			req.getRequestDispatcher("/WEB-INF/views/role/edit.jsp").forward(req, resp);
			break;
		case "/role/delete": 
			String idDelete = req.getParameter("id");
			roleService.deleteById(idDelete);
			resp.sendRedirect(req.getContextPath() + "/role");
			break;
		default:
			break; 
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RoleDto model = new RoleDto(); 
		model.setName(req.getParameter("name"));
		model.setDesc(req.getParameter("description"));
		
		String action = req.getServletPath(); 
		switch (action) {
			case "/role/add": 
				roleService.insert(model);
				break; 
			case "/role/edit":
				model.setId(Integer.valueOf(req.getParameter("id")));	
				roleService.update(model); 
				break; 
			default:
				break; 
		}
		resp.sendRedirect(req.getContextPath() + "/role");
	}
}

// ADMIN: full quyền
// LEADER: không được vào trang role, vào được /user
// USER : chỉ được vào xem công việc, trang cá nhân