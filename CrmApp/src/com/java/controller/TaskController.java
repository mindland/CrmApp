package com.java.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.StatusDao;
import com.java.dto.TaskDto;
import com.java.service.JobService;
import com.java.service.TaskService;
import com.java.service.UserService;


@WebServlet(urlPatterns = {"/task", "/task/add", "/task/detail", "/task/delete",  "/task/edit"})
public class TaskController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private TaskService taskService = null; 
	private JobService jobService = null; 
	private UserService userService = null; 
	private StatusDao statusDao = null;

	@Override
	public void init() throws ServletException {
		taskService = new TaskService();
		jobService = new JobService(); 
		userService = new UserService();
		statusDao = new StatusDao(); 
	}	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String action = req.getServletPath(); 
		
		switch (action) {
		case "/task": 
			req.setAttribute("tasks", taskService.findAll());
			req.getRequestDispatcher("/WEB-INF/views/task/index.jsp").forward(req, resp);
			break; 
		case "/task/add": 	
			req.setAttribute("jobs", jobService.findAll());
			req.setAttribute("users", userService.findAll());
			req.setAttribute("status", statusDao.findAll());
			req.getRequestDispatcher("/WEB-INF/views/task/add.jsp").forward(req, resp);
			break; 
		case "/task/edit": 	
			String idEdit = req.getParameter("id"); 
			TaskDto task = taskService.findById(idEdit); 
			req.setAttribute("task", task);
			req.setAttribute("jobs", jobService.findAll());
			req.setAttribute("users", userService.findAll());
			req.setAttribute("status", statusDao.findAll());
			req.getRequestDispatcher("/WEB-INF/views/task/edit.jsp").forward(req, resp);	
			break; 
		case "/task/delete":
			String idDel = req.getParameter("id"); 
			taskService.delete(idDel); 
			resp.sendRedirect(req.getContextPath() + "/task");
			break; 
//		case "/user/detail": 
//			String idDetail = req.getParameter("id"); 
//			UserDto user = userService.findById(idDetail); 
//			req.setAttribute("user", user);
//			req.getRequestDispatcher("/WEB-INF/views/user/detail.jsp").forward(req, resp);
//			break; 	
		default:
			break; 
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		TaskDto dto = new TaskDto(); 
		dto.setName(req.getParameter("name"));
		dto.setStart_date(Date.valueOf(req.getParameter("start_date")));
		dto.setEnd_date(Date.valueOf(req.getParameter("end_date")));
		dto.setUser_id(Integer.valueOf(req.getParameter("user")));
		dto.setJob_id(Integer.valueOf(req.getParameter("job")));
		dto.setStatus_id(Integer.valueOf(req.getParameter("status")));
		
		String action = req.getServletPath(); 
		
		switch (action) {
			case "/task/add":
				taskService.insert(dto);
				break; 
			case "/task/edit":
				dto.setId(Integer.valueOf(req.getParameter("id")));
				taskService.update(dto);
				break; 
			default:
				break; 
		}
		
		resp.sendRedirect(req.getContextPath() + "/task");
	}	

}
	