package com.bugstrack.domain;

import java.util.Date;

public class Project implements Comparable<Project> {
	private int pId;
	private String pName;
	private String description;
	private Date startDate;
	private String status;
	public Project(String pName, String description, Date startDate, String status) {
		super();
		this.pName = pName;
		this.description = description;
		this.startDate = startDate;
		this.status = status;
	}
	public Project(int pId, String pName, String description, Date startDate, String status) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.description = description;
		this.startDate = startDate;
		this.status = status;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int compareTo(Project project) {
		// TODO Auto-generated method stub
		return this.getpId()-project.getpId();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		else if(!(obj instanceof Project))
			return false;
		Project project=(Project)obj;
		if(this.getpId()==project.getpId())
			return true;
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.pId;
	}
}
