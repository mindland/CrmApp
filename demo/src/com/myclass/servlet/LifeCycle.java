package com.myclass.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "homeServlet" , urlPatterns = {"/home.html", "/trangchu.html"})    // annotation   
public class LifeCycle extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		// sử dụng đối tượng init để khởi tạo biến mặc định , toàn cục nào đấy 
		int bien = 12; 
		System.out.println("hàm init");
	}
	
	public LifeCycle () {
		System.out.println("Hàm khoi tao");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setAttribute("ac", "aaaa");
		System.out.println("Hàm Servive");
		super.service(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// chuyển yêu cầu tạo giao diện cho jsp
		req.getRequestDispatcher("./WEB-INF/view/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("hàm hủy");
	}
	
}

// http server chứa web container  :  nhận gửi resp, req
     // + xml, dùng thẻ servlet, ..... 

// app server chứa các servlet 

