package com.tweetapp.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tweetapp.dao.TweetDao;
import com.tweetapp.dao.UserDao;
import com.tweetapp.model.UserTweet;

public class TweetService {

	public void addTweet(String email) throws SQLException {
		LoginService loginService=new LoginService();
		TweetDao tweetDao=new TweetDao();
		UserTweet userTweet=new UserTweet();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your tweet");
		userTweet.setEmailId(email);
		userTweet.setTweetText(sc.nextLine());
		int result=tweetDao.addTweet(userTweet);
		if(result==1) {
			System.out.println("--------Tweets Registered Successfully-------");
		}
		else {
			System.out.println("--------Please try again --------");
		}
		loginService.userlogged(email);
	}

	public void viewTweet(String email) throws SQLException {
		// TODO Auto-generated method stub
		LoginService loginService=new LoginService();
		TweetDao tweetDao=new TweetDao();
		List<String> tweetlist=new ArrayList<String>();
			tweetlist=tweetDao.getmyTweet(email);
			int count=tweetlist.size();
		if(count==0) {
		System.out.println("You have no tweets");
		
		}
		else {
			tweetlist.forEach((tweet)->System.out.println(tweet));
		}
		loginService.userlogged(email);
		
	}
	public void viewAllTweet(String email) throws SQLException{
		LoginService loginService=new LoginService();
		TweetDao tweetDao=new TweetDao();
		List<String> tweetlist=new ArrayList<String>();
			tweetlist=tweetDao.getAllTweet();
			int count=tweetlist.size();
		if(count==0) {
		System.out.println("no tweets");
		
		}
		else {
			tweetlist.forEach((tweet)->System.out.println(tweet));
		}
		loginService.userlogged(email);
		
	}

	public void viewAllUsers(String email) throws SQLException {
		// TODO Auto-generated method stub
		LoginService loginService=new LoginService();
		TweetDao tweetDao=new TweetDao();
		List<String> tweetlist=new ArrayList<String>();
			tweetlist=tweetDao.getAllUser();
			int count=tweetlist.size();
		if(count==0) {
		System.out.println("No users");
		
		}
		else {
			tweetlist.forEach((tweet)->System.out.println(tweet));
		}
		loginService.userlogged(email);
	}

	public void logoff(String email) throws SQLException {
		// TODO Auto-generated method stub
		UserDao user=new UserDao();
		String status="Inactive";
		user.changeStatus(email,status);
		System.out.println("Logged off successfully");
		
	}
}
