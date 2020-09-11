package com.myclass.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "welcomeServlet", urlPatterns = {"/welcome"})
public class WelcomeServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter(); 
		writer.print("<h1>Welcome Admin!<h1>" + req.getAttribute("fullname"));
		writer.print(req.getParameter("passWord"));
		
		writer.close();
	}
}
