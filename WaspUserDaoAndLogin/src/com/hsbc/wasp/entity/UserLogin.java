package com.hsbc.wasp.entity;

import java.sql.Timestamp;

public class UserLogin {
	private int userId;
	private String emailId;
	private String password;
	private Timestamp lastLogin;
	public UserLogin() {
		super();
	}
	public UserLogin(int userId, String emailId, String password, Timestamp lastLogin) {
		super();
		this.userId = userId;
		this.emailId = emailId;
		this.password = password;
		this.lastLogin = lastLogin;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	@Override
	public String toString() {
		return "UserLogin [userId=" + userId + ", emailId=" + emailId + ", password=" + password + ", lastLogin="
				+ lastLogin + "]";
	}
}
