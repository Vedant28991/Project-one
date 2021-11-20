package com.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LaterPage extends HttpServlet {

	private static final String SELECT_QUERY="select bname from later";

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		writer.println("<table border=1>");
		writer.println("<tr><th>Later-Book</th></tr>");
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb3","root","Vedant28");
		Statement st=con.createStatement();
		ResultSet resultSet=st.executeQuery(SELECT_QUERY);
		
		while(resultSet.next()) {
			writer.println("<tr><td>"+resultSet.getString(1)+"</td></tr>");

		}
		}catch(Exception e) {
			e.printStackTrace();

		}
	
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req,resp);
		
	}
}
