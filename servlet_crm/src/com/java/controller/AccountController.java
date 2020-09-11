package com.java.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.AccountDao;

@WebServlet(urlPatterns = {"/accounts" , "/user_add"})
public class AccountController extends  HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private AccountDao accountDao = null; 
	
	public AccountController() {
		accountDao = new AccountDao(); 
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String action = req.getServletPath(); 
		switch (action) {
			case "/accounts":
				req.setAttribute("accounts", accountDao.getAll());
				req.getRequestDispatcher("/views/account/list.jsp").forward(req, resp);
				break; 
			case "/user_add": 
				req.setAttribute("accounts", accountDao.getAll());
				req.getRequestDispatcher("/views/account/user_add.jsp").forward(req, resp);
				break; 
			default:
				break; 
		}
		
	}
}
