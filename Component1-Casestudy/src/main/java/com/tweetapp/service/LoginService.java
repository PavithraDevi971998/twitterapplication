package com.tweetapp.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.tweetapp.dao.UserDao;

public class LoginService {
	UserService user=new UserService();
	public static void Hello() {
		System.out.println("****Welcome to tweetapp****");
	}
	public void options() throws SQLException {
		System.out.println("Menu options for non-logged in user");
		System.out.println(" 1.Register\n 2.Login\n 3.Forgot Password\n *press other keys to exit the application\n");
		Scanner sc=new Scanner(System.in);
		int choice;
		System.out.println("Please select the option");
		choice=sc.nextInt();
		switch(choice) {
		case 1:System.out.println("Welcome to  Register option");
				user.registerUser();
				
			   break;
		case 2:System.out.println("Welcome to Login option");
		       user.login();
		       break;
		case 3:System.out.println("Welcome to Forgot password option");
		       user.forgotPassword();
		       break;
		default:System.out.println("Exited the tweetapp!!");
			break;
		}
		
	}
	public void userlogged(String email) throws SQLException{
		UserDao user1=new UserDao();
		TweetService tweetService=new TweetService();
		System.out.println("\nMenu options for logged in user");
		System.out.println("Welcome "+email+" choose any option");
		System.out.println(" 1.post a tweet\n 2.view my tweets \n 3.view all tweets\n 4.view all users\n 5.Reset password\n 6.logout\n");
		Scanner sc=new Scanner(System.in);
		int choice;
		System.out.println("Please select the option");
		choice=sc.nextInt();
		  switch(choice) { 
		  case 1:System.out.println("Hurray,Post a tweet!!");
		         tweetService.addTweet(email);
		         break;
		  case 2:System.out.println("My Tweets");
		         tweetService.viewTweet(email);
		         break;
		  case 3:System.out.println("All Tweets");
		         tweetService.viewAllTweet(email);
		         break;
		  case 4:System.out.println("All users");
		  		 tweetService.viewAllUsers(email);
		  		 break;
		  case 5:System.out.println("Reset password");
		         user.forgotPassword();
	             break;
		  case 6:System.out.println("Logoff");
		         tweetService.logoff(email);
		         options();
		  }
	}
}
