package com.tweetapp.service;

import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.tweetapp.dao.UserDao;
import com.tweetapp.model.RegisterUser;

public class UserService {
public void registerUser() throws SQLException{
	LoginService loginService=new LoginService();
	UserDao userDao=new UserDao();
	RegisterUser user=new RegisterUser();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter your firstName(required)");
	user.setFirstName(sc.next());
	System.out.println("Enter your lastName(required)");
	user.setLastName(sc.next());
	System.out.println("Enter your gender(required)");
	user.setGender(sc.next());
	System.out.println("Enter your dob in DD-MM-YYYY format(required)");
	String dob=sc.next();
	 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	    Date date=null;
	    try {
	        date = formatter.parse(dob);
	        String dateValue=formatter.format(date);
	        user.setDob(dateValue);

	    } catch (ParseException e) {
	        //Handle exception
	    	System.out.println("Invalid date format please try again in correct format");
	    	registerUser();
	    }
	System.out.println("Enter your email(required)");
	user.setEmail(sc.next());
	System.out.println("Enter your password(required)");
	user.setPassword(sc.next());
	//if(!user.getFirstName().isEmpty()&&!user.getLastName().isEmpty()&&!user.getGender().isEmpty()&&!user.getDob().isEmpty()&&!user.getEmail().isEmpty()&&!user.getPassword().isEmpty()) 
	boolean result=userDao.addUser(user);
	if(result) {
		System.out.println("--------Details Registered Successfully-------");
	}
	else {
		System.out.println("--------User emailid already there ..Please try again with other email id--------");
	}
	
	//else {
		//System.out.println("Please enter all mandatory fields");
	//}
	loginService.options();
}

public void login() throws SQLException {
	// TODO Auto-generated method stub
	LoginService loginService=new LoginService();
	UserDao userDao=new UserDao();
	RegisterUser user=new RegisterUser();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter your emailid");
	String email=sc.next();
	System.out.println("Enter your password");
	String password=sc.next();
	String dbpassword=userDao.verifyLogin(email);
	if(dbpassword.equals(password)) {
		System.out.println("User logged in successfully!!!");
		String status="Active";
		userDao.changeStatus(email,status);
		loginService.userlogged(email);
	}
	else {
		System.out.println("Incorrect password");
		loginService.options();
	}	
}
public void forgotPassword() throws SQLException {
	LoginService loginService=new LoginService();
	UserDao userDao=new UserDao();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter your Registered emailid");
	String email=sc.next();
	int count=userDao.userCheck(email);
	if(count==1) {
	System.out.println("Enter your new password");
	String password=sc.next();
	System.out.println("Re-enter your new password");
	String newpassword=sc.next();
	if(newpassword.equals(password)) {
		System.out.println("password matched!!");
		int confirm=userDao.changepassword(email,newpassword);
		System.out.println("Password changed successfully!!");
	}
	else{
		System.out.println("password doesn't matched!!");
	}
	}
	else {
		System.out.println("User not present..Please register");
	}
	loginService.options();
}

}
