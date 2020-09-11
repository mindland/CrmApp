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

@WebServlet(name = "thongTinServlet" , urlPatterns = "/thongTinChiTiet")
public class ThongTinChiTiet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String nameString = req.getParameter("userName"); 
		String dateString = req.getParameter("ngaySinh"); 
		String genDerString = req.getParameter("gioiTinh"); 
		String danhXung = " "; 
		
		LocalDate ngaySinh = LocalDate.parse(dateString);
	    int yearCurrent = Year.now().getValue(); 
	    int tuoi = yearCurrent - ngaySinh.getYear(); 
		
		PrintWriter writer = resp.getWriter();
		writer.print("Họ và tên: " + nameString + "<br>");
		writer.print("Tuổi: " + tuoi + "<br>");
		writer.print("Giới tính: " + genDerString + "<br>" );
		
		if(genDerString.equalsIgnoreCase("nam")) {
			danhXung = "anh"; 
		}
		if(genDerString.equalsIgnoreCase("nữ")) {
			danhXung = "chị"; 
		}
		
		writer.print("<h1>Chào mừng " + danhXung + " đến với Servlet</h1>");
		
		writer.close();
	}

}
