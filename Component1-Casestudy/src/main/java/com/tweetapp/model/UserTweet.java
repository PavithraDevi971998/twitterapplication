package com.tweetapp.model;

public class UserTweet {
private String emailId;
private String tweetText;
public UserTweet() {
	
}
public UserTweet(String emailId, String tweetText) {
	super();
	this.emailId = emailId;
	this.tweetText = tweetText;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getTweetText() {
	return tweetText;
}
public void setTweetText(String tweetText) {
	this.tweetText = tweetText;
}
@Override
public String toString() {
	return "UserTweet [emailId=" + emailId + ", tweetText=" + tweetText + "]";
}

}
