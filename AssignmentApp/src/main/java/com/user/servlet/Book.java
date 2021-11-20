package com.user.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Book extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String bname=req.getParameter("bookname");
		String choice=req.getParameter("choice");
		
		RequestDispatcher rd=null;
		
		if(choice.equals("Like")) {
	
			rd=req.getRequestDispatcher("/like");
			req.setAttribute("like", bname);
			
		}else {
		
			rd=req.getRequestDispatcher("/later");
			req.setAttribute("later", bname);
			
		}
			
		rd.forward(req, resp);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

}
