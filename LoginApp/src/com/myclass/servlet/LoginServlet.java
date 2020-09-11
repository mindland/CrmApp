package com.myclass.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loginServlet", urlPatterns = "/login")

public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String urlString = req.getContextPath() + req.getServletPath(); 
		req.setAttribute("appName", urlString);
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// B1:  Lấy thông tin từ client gửi lên 
		
		// lấy tên project
		System.out.println(req.getContextPath());
		
		// lấy ra phương thức gửi lên
		System.out.println(req.getMethod());
		
		// Lấy url (action)
		System.out.println(req.getServletPath());
		
		// Lấy thông tin người dùng nhập vào form 
		System.out.println(req.getParameter("usrName"));
		System.out.println(req.getParameter("passWord"));
		
		// B2: Kiểm tra đăng nhập
		String name = req.getParameter("usrName"); 
		String pass = req.getParameter("passWord"); 
		
		PrintWriter writer = resp.getWriter();
		
			// + Đúng :  đăng nhập thành công
		if(name.equals("admin")  && pass.equals("123456")) {
			
			req.setAttribute("fullname", "Phong Pham");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/welcome"); 
			dispatcher.forward(req, resp);
		
//			resp.sendRedirect("/LoginApp/welcome.html");
			
		}
		else {// + Sai: sysout dòng "Sai email hoặc mật khẩu"
			resp.sendRedirect("/LoginApp/login");
		}
		
		
		// Phân biệt forward và redirect 
		// chuyển tiếp và chuyển hướng
		
		
	}
	
}
