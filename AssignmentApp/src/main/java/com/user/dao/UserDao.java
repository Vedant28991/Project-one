package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.user.pojo.User;
import com.user.util.DBConnection;

public class UserDao {

	
public int saveUser(User user) {
		
		int i=-1;
		
		Connection con=DBConnection.getDBConnection();
		
		try {
			
			PreparedStatement ps=con.prepareStatement("insert into user(name,password) values(?,?)");
			
			ps.setString(1,user.getName() );
			ps.setString(2,user.getPassword());
			
			i = ps.executeUpdate();

			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return i;
		
	}


public List<User> getUser() {
	
	List<User> userList = new ArrayList<>();
	try {
		
	Connection con = DBConnection.getDBConnection();

	Statement statement = con.createStatement();

	ResultSet resultSet = statement.executeQuery("select name,password from user");

	while (resultSet.next()) {

		
		User user=new User();
		user.setName(resultSet.getString(1));
		user.setPassword(resultSet.getString(2));
		
		userList.add(user);
		
	
	}
	
	}catch (SQLException e) {
		e.printStackTrace();
	}

	return userList;

}
	
	
}
