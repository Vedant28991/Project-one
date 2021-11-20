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

public class Later extends HttpServlet {

	private static final String INSERT_LATER="insert into later(bname) values(?) ";

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String later=(String) req.getAttribute("later");
			
			Connection con=DBConnection.getDBConnection();
			
			try {
				PreparedStatement ps=con.prepareStatement(INSERT_LATER);
				ps.setString(1, later);
				int rows=ps.executeUpdate();
				//con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			out.println("<html><body>");
			out.println("<p style='color:blue;'>Book Data Added to Later Database successfully!</p>");
			out.println("<a href='./laterpage'>Click Here to see Later Books</a>");
			out.println("</body> </html>");

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req,resp);
	}
}
