package com.bugstrack.domain;

public class Roles implements Comparable<Roles>{
	
	private int userId;
	private String Roles;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getRole() {
		return Roles;
	}
	public void setRole(String role) {
		this.Roles = role;
	}
	public Roles(int userId, String role) {
		super();
		this.userId = userId;
		this.Roles = role;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Roles == null) ? 0 : Roles.hashCode());
		result = prime * result + userId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Roles other = (Roles) obj;
		if (Roles == null) {
			if (other.Roles != null)
				return false;
		} else if (!Roles.equals(other.Roles))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Roles o) {
		return this.userId - o.userId;
	}
	
	

}
