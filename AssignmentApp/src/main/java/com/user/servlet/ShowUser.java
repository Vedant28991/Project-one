package com.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.user.dao.UserDao;
import com.user.pojo.User;

public class ShowUser extends HttpServlet {

	

	private static UserDao userDao=new UserDao();

	private static RequestDispatcher requestDispatcher;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<User> users = userDao.getUser();

		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();

		writer.println("<table border=1>");
		writer.println("<tr><th>User-Name</th><th>Password</th><th>");
		for (User employ : users) {
			writer.println("<tr><td>" + employ.getName() + "</td><td>" + employ.getPassword());
		}
		writer.println("</table>");

		requestDispatcher = req.getRequestDispatcher("register-user.html");
		requestDispatcher.include(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}

	
	
}
