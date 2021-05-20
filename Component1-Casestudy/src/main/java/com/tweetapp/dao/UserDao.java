package com.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tweetapp.model.RegisterUser;

public class UserDao {
static Connection connection=DbConnection.getConnection();
public boolean addUser(RegisterUser user) throws SQLException {
	boolean userstatus=false;
	/*
	 * String query="SELECT count(*) from tweetapp.register where email=? ";
	 * PreparedStatement preparedStatement=connection.prepareStatement(query);
	 * preparedStatement.setString(1,user.getEmail()); ResultSet
	 * resultSet=preparedStatement.executeQuery(); int count=-1;
	 * while(resultSet.next()) { count=Integer.parseInt(resultSet.getString(1)); }
	 * if(count==0) {
	 */
	String insertQuery="insert into register(firstName,lastName,gender,dob,email,password) values(?,?,?,?,?,?)";
		PreparedStatement statement=connection.prepareStatement(insertQuery);
			statement.setString(1,user.getFirstName());
			statement.setString(2,user.getLastName());
			statement.setString(3,user.getGender());
			statement.setString(4,user.getDob());
			statement.setString(5,user.getEmail());
			statement.setString(6,user.getPassword());
			statement.executeUpdate();
			userstatus=true;
			// } else { userstatus=false; }
			 
	return userstatus;	
}
public String verifyLogin(String email) throws SQLException {
	String query="SELECT password from tweetapp.register where email=? ";
	PreparedStatement preparedStatement=connection.prepareStatement(query);
	preparedStatement.setString(1,email);
	ResultSet resultSet=preparedStatement.executeQuery();
	String password=null;
	while(resultSet.next()) {
		password=resultSet.getString(1);
	}
	
	return password;
	
	
}
public int userCheck(String email) throws SQLException {
	// TODO Auto-generated method stub
	String query="SELECT count(*) from tweetapp.register where email=?";
	PreparedStatement preparedStatement=connection.prepareStatement(query);
	preparedStatement.setString(1,email);
	ResultSet resultSet=preparedStatement.executeQuery();
	int count=0;
	while(resultSet.next()) {
		count=Integer.parseInt(resultSet.getString(1));
	}
	return count;
}
public int changepassword(String email, String newpassword) throws SQLException {
	// TODO Auto-generated method stub
	String query="UPDATE register SET password=? where email=?";
	PreparedStatement preparedStatement=connection.prepareStatement(query);
	preparedStatement.setString(1,newpassword);
	preparedStatement.setString(2, email);
	int count=preparedStatement.executeUpdate();
	return count;
}
public void changeStatus(String email, String status) throws SQLException {
	// TODO Auto-generated method stub
	String query="UPDATE register SET status=? where email=?";
	PreparedStatement preparedStatement=connection.prepareStatement(query);
	preparedStatement.setString(1,status);
	preparedStatement.setString(2, email);
	int count=preparedStatement.executeUpdate();
}
}
