package com.java.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dto.JobDto;
import com.java.service.JobService;

@WebServlet(urlPatterns = {"/job", "/job/add", "/job/detail", "/job/edit", "/job/delete"})
public class JobController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private JobService jobService = null; 
	
	@Override
	public void init() throws ServletException {
		jobService = new JobService(); 
	}
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String action = req.getServletPath(); 
		
		switch (action) {
		case "/job": 
			req.setAttribute("jobs",jobService.findAll());
			req.getRequestDispatcher("/WEB-INF/views/job/index.jsp").forward(req, resp);
			break; 
		case "/job/add": 
			req.getRequestDispatcher("/WEB-INF/views/job/add.jsp").forward(req, resp);
			break; 
		case "/job/delete": 
			String idDelete = req.getParameter("id");
			jobService.delete(idDelete);
			resp.sendRedirect(req.getContextPath() + "/job");
			break; 
		case "/job/edit": 
			String idEdit = req.getParameter("id"); 
			JobDto model = jobService.findById(idEdit);
			req.setAttribute("job", model);
			req.getRequestDispatcher("/WEB-INF/views/job/edit.jsp").forward(req, resp);
			break; 
		case "/job/detail": 
			req.getRequestDispatcher("/WEB-INF/views/job/detail.jsp").forward(req, resp);
			break; 
		default:
			break; 
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		JobDto model = new JobDto(); 
		model.setName(req.getParameter("name"));
		model.setStart_date(Date.valueOf(req.getParameter("start_date")));
		model.setEnd_date(Date.valueOf(req.getParameter("end_date")));
	
		String action = req.getServletPath(); 
		
		switch (action) {
		case "/job/add": 
			jobService.insert(model); 
			break; 
		case "/job/edit": 
			model.setId(Integer.valueOf(req.getParameter("id")));
			jobService.update(model); 
			break; 
		default:
			break; 
		}
		resp.sendRedirect(req.getContextPath() + "/job");
	}
}
