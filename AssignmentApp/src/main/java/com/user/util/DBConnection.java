package com.user.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	
	private static Connection connection;

	public static Connection getDBConnection() {

		if (connection == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb3", "root", "Vedant28");

			} catch (Exception e) {
				System.out.println("exception is: " + e.getMessage());
			}
		}

		return connection;

	}
	
}