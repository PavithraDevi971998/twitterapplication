package com.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tweetapp.model.UserTweet;

public class TweetDao {
	static Connection connection=DbConnection.getConnection();
	
	public int addTweet(UserTweet userTweet) throws SQLException {
		// TODO Auto-generated method stub
		String insertQuery="insert into tweet(emailId,tweetText) values(?,?)";
		PreparedStatement statement=connection.prepareStatement(insertQuery);
			statement.setString(1,userTweet.getEmailId());
			statement.setString(2,userTweet.getTweetText());
			int count=statement.executeUpdate();
		return count;
	}

	public List<String> getmyTweet(String email) throws SQLException {
		String insertQuery="select * from tweet where emailId=?";
		PreparedStatement statement=connection.prepareStatement(insertQuery);
		statement.setString(1,email);
		List<String> tweetlist=new ArrayList<String>();
		ResultSet resultSet=statement.executeQuery();
		while(resultSet.next()) {
			List<String> tweetdata=new ArrayList<String>();
			tweetdata.add(resultSet.getString(2));
			//tweetdata.add(resultSet.getString(2));
			tweetlist.addAll(tweetdata);
		}
		// TODO Auto-generated method stub
		return tweetlist;
	}

	public List<String> getAllTweet() throws SQLException {
		String insertQuery="select * from tweet";
		PreparedStatement statement=connection.prepareStatement(insertQuery);
		List<String> tweetlist=new ArrayList<String>();
		ResultSet resultSet=statement.executeQuery();
		while(resultSet.next()) {
			List<String> tweetdata=new ArrayList<String>();
			tweetdata.add(resultSet.getString(2));
			//tweetdata.add(resultSet.getString(2));
			tweetlist.addAll(tweetdata);
		}
		// TODO Auto-generated method stub
		return tweetlist;
	}

	public List<String> getAllUser() throws SQLException {
		// TODO Auto-generated method stub
		String insertQuery="select firstName,email from register";
		PreparedStatement statement=connection.prepareStatement(insertQuery);
		List<String> tweetlist=new ArrayList<String>();
		ResultSet resultSet=statement.executeQuery();
		while(resultSet.next()) {
			List<String> tweetdata=new ArrayList<String>();
			tweetdata.add(resultSet.getString(1));
			tweetdata.add(resultSet.getString(2));
			tweetlist.addAll(tweetdata);
		}
		// TODO Auto-generated method stub
		return tweetlist;
	}

	
}
