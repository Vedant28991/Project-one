package com.user.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.UserDao;
import com.user.pojo.User;

public class RegisterUser extends HttpServlet {

	
	public static UserDao userDao;
	
	private static RequestDispatcher requestDispatcher;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		
		User user=new User();
		
		user.setName(name);
		user.setPassword(password);
		
		userDao=new UserDao();
		int i=userDao.saveUser(user);
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>");
		if(i!=-1) {
			writer.println("<p style='color:blue'> User info saved successfully.!</p>");
		}
		else {
			writer.println("<p style='color:blue'> User info saved successfully.!</p>");
		}
		
		requestDispatcher = req.getRequestDispatcher("registered-user.html");
		requestDispatcher.include(req, resp);
		
		
	}
	
	
	
}
