package com.tweetapp.dao;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
public class DbConnection {

	static Connection con=null;
	static {
		try {
			Properties properties=new Properties();
			//FileInputStream file=new FileInputStream("C:\\Users\\User\\TweetApp\\TweetApp\\src\\main\\resources\\application.properties");
			//properties.load(file);
			//file.close();
			//String url="jdbc:mysql://localhost:3306/tweetapp";//properties.getProperty("jdbc.url");
			//String username=""//properties.getProperty("jdbc.username");
			//String password=properties.getProperty("jdbc.password");
			//String driverName=properties.getProperty("jdbc.driver");
			//Class.forName(driverName);
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tweetapp","root","");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		public static Connection getConnection() {
			return con;
		}
	
}
