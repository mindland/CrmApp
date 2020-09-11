package com.myclass.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "homeServlet", urlPatterns = {"/home.html"} )
public class HomeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		resp.setContentType("text/html");
//		resp.setCharacterEncoding("utf-8");
		String urString = req.getContextPath() + "/login"; 
		req.setAttribute("url", urString);
		req.getRequestDispatcher("home.jsp").forward(req, resp);
	}
	
	@Override
	public void destroy() {
		System.out.println("hàm hủy");
	}

}
