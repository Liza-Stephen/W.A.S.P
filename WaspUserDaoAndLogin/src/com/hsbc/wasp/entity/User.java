package com.hsbc.wasp.entity;
public class User {
	private int userId;
	private String userName;
	private String emailId;
	private String role;
	public User() {
		super();
	}
	
	public User(int userId, String userName, String emailId, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
		this.role = role;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}	
}
