package com.myclass.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		System.out.println("connect thanh cong");
		String action = req.getServletPath(); 
		switch (action) {
		case "/home": 	
			req.getRequestDispatcher("/WEB-INF/views/home/index.jsp").forward(req, resp);
			break;
		default:
			break; 
		}
	}
}
