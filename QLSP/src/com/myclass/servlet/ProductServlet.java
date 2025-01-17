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
import com.myclass.entity.Products;
import com.myclass.dao.CategoryDao;
import com.myclass.dao.ProductDao;

@WebServlet(urlPatterns = {"/product", "/product/add", "/product/edit", "/product/delete"})
public class ProductServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ProductDao productDao = null; 
	private CategoryDao categoryDao = null; 
	
	@Override
	public void init() throws ServletException {
		productDao = new ProductDao(); 
		categoryDao = new CategoryDao(); 
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String action = req.getServletPath(); 
		
		switch (action) {
			case "/product" : 
				req.setAttribute("products", productDao.findAll());   
				req.getRequestDispatcher("/WEB-INF/views/product/index.jsp").forward(req, resp);
				break;	
			case "/product/add": 
				List<Category> listCategories = categoryDao.findAll(); 
			 	req.setAttribute("categories", listCategories);
				req.getRequestDispatcher("/WEB-INF/views/product/add.jsp").forward(req,resp);
				break;
			case "/product/edit": 
				String id = req.getParameter("id"); 
				Products product = productDao.findById(id); 
				req.setAttribute("sanPham", product);
				req.setAttribute("categories", categoryDao.findAll());
				req.getRequestDispatcher("/WEB-INF/views/product/edit.jsp").forward(req,resp);
				break;
			case "/product/delete": 
				String idDelete = req.getParameter("id"); 
				productDao.delete(idDelete);
				resp.sendRedirect(req.getContextPath() + "/product");
				break;
			default:
				break; 	
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String maSP = req.getParameter("maSanPham");
		String cateId = req.getParameter("cateId");
		String tenSP = req.getParameter("tenSanPham");
		int soLuong = Integer.valueOf(req.getParameter("soLuong")) ; 
		float giaBan = Float.valueOf(req.getParameter("giaBan")); 
		
		Products product = new Products(maSP,cateId,tenSP,soLuong,giaBan); 
		
		String action = req.getServletPath(); 
		switch (action) {
			case "/product/add": 
				productDao.insert(product);
				break;
			case "/product/edit": 	
				productDao.update(product);
				break;
			default:
				break; 	
		}	
		resp.sendRedirect(req.getContextPath() +  "/product");
	}
}
