package com.java.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.dto.UserDto;
import com.java.service.UserService;

@WebServlet(urlPatterns = {"/login", "/logout"})
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = null; 
	
	@Override
	public void init() throws ServletException {
		userService = new UserService(); 
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		String action = req.getServletPath(); 
		
		switch (action) {
			case "/login":
				req.getRequestDispatcher("/WEB-INF/views/login/index.jsp").forward(req, resp);
				break; 
			case "/logout":
				HttpSession session = req.getSession(); 
				session.removeAttribute("USER");
				resp.sendRedirect(req.getContextPath() + "/login");
				break; 
			default:
				break; 
		}	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email"); 
		String password = req.getParameter("password"); 

		UserDto modelDto = userService.checkLoginUserDto(email, password); 
		
		if(modelDto != null) {
			HttpSession session = req.getSession(); 
			session.setAttribute("USER", modelDto);
			
			resp.sendRedirect(req.getContextPath() + "/home");
		}
		else {
			String message = "Thông tin đăng nhập không đúng !"; 
			req.setAttribute("message", message);
			req.getRequestDispatcher("/WEB-INF/views/login/index.jsp").forward(req, resp);
		}
	}
}
