package com.myclass.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.dao.CategoryDao;
import com.myclass.dao.ProductDao;
import com.myclass.entity.Category;
import com.myclass.entity.Product;

@WebServlet(urlPatterns = { "/product", "/product/add", "/product/edit", "/product/delete" })
public class ProductServlet extends HttpServlet {

	private ProductDao productDao = null;
	private CategoryDao categoryDao = null;

	@Override
	public void init() throws ServletException {
		productDao = new ProductDao();
		categoryDao = new CategoryDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String action = req.getServletPath();

		switch (action) {
		case "/product":
			// Thêm danh sách sản phẩm vào request => truyền qua cho index.jsp
			req.setAttribute("products", productDao.findAll());
			req.getRequestDispatcher("/WEB-INF/views/product/index.jsp").forward(req, resp);
			break;
		case "/product/add":
			List<Category> listCategories = categoryDao.findAll();
			req.setAttribute("categories", listCategories);
			req.getRequestDispatcher("/WEB-INF/views/product/add.jsp").forward(req, resp);
			break;
		case "/product/edit":
			// Bước 1: Lấy mã sản phẩm truyền lên từ client
			String id = req.getParameter("id");
			req.setAttribute("product", productDao.findById(id));
			req.getRequestDispatcher("/WEB-INF/views/product/edit.jsp").forward(req, resp);
			break;
		case "/product/delete":
			// Bước 1: Lấy mã sản phẩm truyền lên từ client
			String idDel = req.getParameter("id");
			productDao.delete(idDel);
			resp.sendRedirect(req.getContextPath() + "/product");
			break;
		default:
			break;

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String action = req.getServletPath();

		// Bước 1: Lấy dữ liệu từ các ô input của form
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		int quantity = Integer.valueOf(req.getParameter("quantity"));
		float price = Float.valueOf(req.getParameter("price"));
		String cateId = req.getParameter("cateId");
		
		Product product = new Product(id, name, quantity, price, cateId);

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
		// Bước 4: Chuyển hướng về trang danh sách
		resp.sendRedirect(req.getContextPath() + "/product");
	}
}
