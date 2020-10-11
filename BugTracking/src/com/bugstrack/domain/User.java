package com.bugstrack.domain;

import java.util.Date;

public class User {
	private int userId;
	private String userName;
	private String emailId;
	private String password;
	private Date lastLoggedin;
	private boolean isRegistered;
	public User(String userName, String emailId) {
		super();
		this.userName = userName;
		this.emailId = emailId;
	}
	
	public User(int userId,String emailId, String password) {
		super();
		this.userId=userId;
		this.emailId = emailId;
		this.password = password;
	}

	public User(int userId, String userName, String emailId, String password, Date lastLoggedin, boolean isRegistered) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
		this.lastLoggedin = lastLoggedin;
		this.isRegistered = isRegistered;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getLastLoggedin() {
		return lastLoggedin;
	}
	public void setLastLoggedin(Date lastLoggedin) {
		this.lastLoggedin = lastLoggedin;
	}
	public boolean isRegistered() {
		return isRegistered;
	}
	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}
	@Override
	public boolean equals(Object arg) {
		// TODO Auto-generated method stub
		if(arg==null)
			return false;
		else if(!(arg instanceof User))
			return false;
		User user=(User)arg;
		return this.getUserId()==user.getUserId();
	}
	
}
