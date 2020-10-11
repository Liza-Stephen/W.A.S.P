package com.bugstrack.domain;

public class UserLoggedIn implements Comparable<UserLoggedIn>{
	
	private int userId;

	public UserLoggedIn(int userId) {
		super();
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		UserLoggedIn other = (UserLoggedIn) obj;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	@Override
	public int compareTo(UserLoggedIn o) {
		return this.userId - o.userId;
	}

}
