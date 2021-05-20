package com.tweetapp;
import java.sql.SQLException;

import com.tweetapp.service.*;
public class TweetApp {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		LoginService.Hello();
		LoginService login=new LoginService();
		login.options();

	}

}
