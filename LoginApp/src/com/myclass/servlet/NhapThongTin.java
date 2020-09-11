package com.myclass.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Year;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
	
@WebServlet(name = "formServlet", urlPatterns = "/form")
public class NhapThongTin extends HttpServlet {

	/** Người tạo : Phạm Võ Đức Phong
	 * Ngày tạo: 21/08/2020
	 */
	private static final long serialVersionUID = 1L;	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");	
		
		String urlString = req.getContextPath() + req.getServletPath(); 
		
		PrintWriter writer = resp.getWriter();
		writer.print("<form action=\" " + urlString + "\" method=\"POST\">");
		writer.print("<label>Tên đầy đủ:</label><br>");
		writer.print("<input type=\"text\" name=\"userName\"><br>");
		writer.print("<label>Ngày sinh:</label><br>");
		writer.print("<input type=\"date\" name=\"ngaySinh\"><br>");
		writer.print("<label>Giới tính:</label><br>");
		writer.print("<input type=\"text\" name=\"gioiTinh\"><br><br>");
		writer.print("<input type=\"submit\" value=\"Submit\">");
		writer.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String urlString = req.getContextPath() + req.getServletPath(); 
		
		String nameString = req.getParameter("userName"); 
		String dateString = req.getParameter("ngaySinh"); 
		String genDerString = req.getParameter("gioiTinh");
		
		if(nameString.length() > 0  && dateString.length() > 0 && genDerString.length() > 0) {
			req.getRequestDispatcher("/thongTinChiTiet").forward(req, resp);
		}	
		else {
			resp.sendRedirect(urlString);
		}
	}
}
