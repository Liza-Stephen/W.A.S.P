package com.bugstrack.domain;

public class Roles {
	private int userId;
	private String roles;
	
	public Roles(int userId, String roles) {
		super();
		this.userId = userId;
		this.roles = roles;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	
}
