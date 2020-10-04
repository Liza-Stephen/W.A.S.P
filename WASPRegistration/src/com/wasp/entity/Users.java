package com.wasp.entity;

import java.sql.Date;

public class Users {
	
	private int userid;
	private String username;
	private String role;
	private String email;
	private Date lastLogin;
	private String password;
	
	public Users(int userid, String username, String role, String email, Date lastLogin,String password) {
		super();
		this.userid = userid;
		this.username = username;
		this.role = role;
		this.email = email;
		this.lastLogin = lastLogin;
		this.password = password;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	//Not printing the password using toString overridding method.
	@Override
	public String toString() {
		return "Users [userid=" + userid + ", username=" + username + ", role=" + role + ", email=" + email
				+ ", lastLogin=" + lastLogin + "]";
	}
	
}
