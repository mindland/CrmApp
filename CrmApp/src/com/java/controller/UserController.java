package com.java.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dto.UserDto;
import com.java.service.RoleService;
import com.java.service.UserService;

@WebServlet(urlPatterns = {"/user", "/user/add", "/user/detail", "/user/delete", "/user/edit"})
public class UserController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private UserService userService = null; 
	private RoleService roleService = null;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService(); 
		roleService = new RoleService(); 
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String action = req.getServletPath(); 
		
		switch (action) {
		case "/user": 
			req.setAttribute("users", userService.findAll());
			req.getRequestDispatcher("/WEB-INF/views/user/index.jsp").forward(req, resp);
			break; 
		case "/user/add": 
			req.setAttribute("roles", roleService.findAll());
			req.getRequestDispatcher("/WEB-INF/views/user/add.jsp").forward(req, resp);
			break; 
		case "/user/edit": 
			String idEdit = req.getParameter("id"); 
			UserDto model = userService.findById(idEdit); 
			req.setAttribute("user", model);
			req.setAttribute("roles", roleService.findAll());
			req.getRequestDispatcher("/WEB-INF/views/user/edit.jsp").forward(req, resp);
			break; 
		case "/user/delete":
			String idDel = req.getParameter("id"); 
			userService.delete(idDel); 
			resp.sendRedirect(req.getContextPath() + "/user");
			break; 
		case "/user/detail": 
			String idDetail = req.getParameter("id"); 
			UserDto user = userService.findById(idDetail); 
			req.setAttribute("user", user);
			req.getRequestDispatcher("/WEB-INF/views/user/detail.jsp").forward(req, resp);
			break; 	
		default:
			break; 
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		UserDto model = new UserDto(); 
		model.setEmail(req.getParameter("email"));
		model.setPassword(req.getParameter("password"));
		model.setFullname(req.getParameter("fullname"));
		model.setPhone(req.getParameter("phone"));
		model.setAddress(req.getParameter("address"));
		model.setAvatar(req.getParameter("avatar"));
		model.setRole_id(Integer.valueOf(req.getParameter("role")));
		model.setRoleName(req.getParameter("role"));
		
		String action = req.getServletPath(); 
		switch (action) {
			case "/user/edit": 
				model.setId(Integer.valueOf(req.getParameter("id")));
				userService.update(model);
				break; 
			case "/user/add": 
				userService.insert(model);
				break;			
			default:
				break; 
		}
		resp.sendRedirect(req.getContextPath() + "/user");
	}
}
