package com.java.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.SetAllPropertiesRule;

import com.java.dao.RoleDao;

@WebServlet(urlPatterns = {"/role", "/role/add"})
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
			req.getRequestDispatcher("/WEB-INF/views/role/index.jsp").forward(req, resp);
			break;
		case "/role/add": 
			req.getRequestDispatcher("/WEB-INF/views/role/add.jsp").forward(req, resp);
			break;
		default:
			break; 
		}
	}
}