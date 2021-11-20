package com.user.servlet;

import java.io.IOException;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.util.DBConnection;

public class Like extends HttpServlet {

	private static final String INSERT_LIKE="insert into likes(bname) values(?) ";
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String liked=(String) req.getAttribute("like");
	//	String liked=req.getParameter("like");
		
		Connection con=DBConnection.getDBConnection();
		
		try {
			PreparedStatement ps=con.prepareStatement(INSERT_LIKE);
			ps.setString(1, liked);
			int rows=ps.executeUpdate();
			//con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html><body>");
		out.println("<p>Book Data Added to Like Database successfully!</p>");
		out.println("<a href='./likepage'>Click Here to see Liked Books</a>");
		out.println("</body> </html>");

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	
}
