package com.myclass.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.entity.Category;
import com.myclass.dao.CategoryDao;

@WebServlet(urlPatterns = { "/category", "/category/add", "/category/edit", "/category/delete" })
public class CategoryServlet extends HttpServlet {

	private CategoryDao categoryDao = null;  
	
	@Override
	public void init() throws ServletException {
		categoryDao = new CategoryDao(); 
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String action = req.getServletPath();
		switch (action) {
		case "/category":
			List<Category> listCate = categoryDao.findAll(); 
			req.setAttribute("categories", listCate);
			req.getRequestDispatcher("/WEB-INF/views/category/index.jsp").forward(req, resp);
			break;
		case "/category/add":
			req.getRequestDispatcher("/WEB-INF/views/category/add.jsp").forward(req, resp);
			break;
		case "/category/edit":
			String id = req.getParameter("id");
			Category category = categoryDao.findById(id);
			req.setAttribute("category", category);
			req.getRequestDispatcher("/WEB-INF/views/category/edit.jsp").forward(req, resp);
			break;
		case "/category/delete":
			String idDelete = req.getParameter("id");
			categoryDao.delete(idDelete);
			resp.sendRedirect("/QLSP/category");
			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		String name = req.getParameter("name");	
		String desc = req.getParameter("desc");
		Category category = new Category(id, name, desc);
		
		String action = req.getServletPath();
		switch (action) {
		case "/category/add":
			categoryDao.insert(category);
			break;
		case "/category/edit":
			categoryDao.update(category);
			break;
		default:
			break;
		}
		resp.sendRedirect(req.getContextPath() + "/category");
	}
}
