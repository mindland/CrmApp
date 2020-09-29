package com.java.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.dto.UserDto;

public class AuthFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request; 
		HttpServletResponse resp = (HttpServletResponse)response; 
		
		// kiểm tra nếu là trang login thì k cần kiểm tra session
		if( req.getServletPath().startsWith("/login")) {
			chain.doFilter(request, response);
			return; 
		}
		
		// Kiểm tra session, nếu chưa đăng nhập thì đăng nhập
		HttpSession session = req.getSession(); 
		if(session.getAttribute("USER") == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return; 
		}
		
		// Nếu đã đăng nhập thì tiến hành phân quyền
		UserDto userDto = (UserDto) session.getAttribute("USER"); 
		String roleName = userDto.getRoleName(); 
		
		// th1: nếu là /role thì phải có rolename là ROLE_ADMIN
		if(req.getServletPath().startsWith("/role")) {
			if(roleName.equals("ROLE_ADMIN")) {
				chain.doFilter(request, response); 
				return; 
			}
		}
		
		// th2: nêu là /user thì phải có rolename là ROLE_ADMIN hoặc ROLE_LEADER
		if(req.getServletPath().startsWith("/user")) {
			if(roleName.equals("ROLE_ADMIN") || roleName.equals("ROLE_MANAGER")) {
				chain.doFilter(request, response); 
				return; 
			}	
		}
			
		// th3 : Nếu là /home thì rolename thì là ROLE_ADMIN hoặc ROLE_LEADER hoặc ROLE_USER	
		if(req.getServletPath().startsWith("/home")) {
			if(roleName.equals("ROLE_ADMIN") || roleName.equals("ROLE_MANAGER") || roleName.equals("ROLE_USER")) {
				chain.doFilter(request, response); 
				return; 
			}	
		}		
		
		// các trường hợp còn lại
		resp.sendRedirect(req.getContextPath() + "/login");	
	}
}
