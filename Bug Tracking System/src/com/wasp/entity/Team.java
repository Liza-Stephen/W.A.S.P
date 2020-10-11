package com.wasp.entity;

public class Team implements Comparable<Team> {
	private int userId;
	private int pId;
	public Team(int userId, int pId) {
		super();
		this.userId = userId;
		this.pId = pId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int compareTo(Team team) {
		// TODO Auto-generated method stub
		return this.getpId()+this.getUserId()-team.getpId()-team.getUserId();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj==null)
			return false;
		else if(!(obj instanceof Team))
			return false;
		Team team=(Team)obj;
		if(this.getpId()==team.getpId()&&this.getUserId()==team.getUserId())
			return true;
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.pId+this.userId;
	}
	@Override
	public String toString() {
		return "{userId:" + userId + ", pId:" + pId + "}";
	}
	
	
}
