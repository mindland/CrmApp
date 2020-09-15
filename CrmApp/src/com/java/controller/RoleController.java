package com.java.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.RoleDao;
import com.java.model.Role;

@WebServlet(urlPatterns = {"/role", "/role/add", "/role/delete", "/role/edit"})
public class RoleController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private RoleDao roleDao = null; 
	
	@Override
	public void init() throws ServletException {
		roleDao = new RoleDao(); 
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String action = req.getServletPath(); 
		switch (action) {
		case "/role": 
			req.setAttribute("roles", roleDao.findAll());
			req.getRequestDispatcher("/WEB-INF/views/role/index.jsp").	forward(req, resp);
			break;
		case "/role/add": 
			req.getRequestDispatcher("/WEB-INF/views/role/add.jsp").forward(req, resp);
			break;
		case "/role/edit": 
			String idEdit =  req.getParameter("id");
			Role model = roleDao.findById(idEdit); 
			req.setAttribute("role", model);
			req.getRequestDispatcher("/WEB-INF/views/role/edit.jsp").forward(req, resp);
			break;
		case "/role/delete": 
			String idDelete = req.getParameter("id");
			roleDao.delete(idDelete);
			resp.sendRedirect(req.getContextPath() + "/role");
			break;
		default:
			break; 
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		Role model = new Role(); 
		model.setName(req.getParameter("name"));
		model.setDescription(req.getParameter("description"));
		
		String action = req.getServletPath(); 
		switch (action) {
			case "/role/add": 
				roleDao.insert(model);
				break; 
			case "/role/edit":
				model.setId(Integer.valueOf(req.getParameter("id")));	
				roleDao.update(model); 
				break; 
			default:
				break; 
		}
		resp.sendRedirect(req.getContextPath() + "/role");
	}
}
