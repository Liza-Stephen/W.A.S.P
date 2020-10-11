package com.bugstrack.domain;

import java.util.Date;

public class Bug implements Comparable<Bug> {
	
	private int bugId;
	private String title;
	private String  description;
	private int pid;
	private int testerId;
	private Date openDate;
	private int  assignedto;
	private boolean  isMarkedforClosing;
	private int closedBy;
	private Date closedOn;
	private String status;
	private String  severityLevel;
	public Bug(String title, String description, int pid, int testerId, Date openDate, String status,
			String severityLevel) {
		super();
		this.title = title;
		this.description = description;
		this.pid = pid;
		this.testerId = testerId;
		this.openDate = openDate;
		this.status = status;
		this.severityLevel = severityLevel;
	}
	public Bug(int bugId, String title, String description, int pid, int testerId, Date openDate, int assignedto,
			boolean isMarkedforClosing, int closedBy, Date closedOn, String status, String severityLevel) {
		super();
		this.bugId = bugId;
		this.title = title;
		this.description = description;
		this.pid = pid;
		this.testerId = testerId;
		this.openDate = openDate;
		this.assignedto = assignedto;
		this.isMarkedforClosing = isMarkedforClosing;
		this.closedBy = closedBy;
		this.closedOn = closedOn;
		this.status = status;
		this.severityLevel = severityLevel;
	}
	public int getBugId() {
		return bugId;
	}
	public void setBugId(int bugId) {
		this.bugId = bugId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getTesterId() {
		return testerId;
	}
	public void setTesterId(int testerId) {
		this.testerId = testerId;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public int getAssignedto() {
		return assignedto;
	}
	public void setAssignedto(int assignedto) {
		this.assignedto = assignedto;
	}
	public boolean isMarkedforClosing() {
		return isMarkedforClosing;
	}
	public void setMarkedforClosing(boolean isMarkedforClosing) {
		this.isMarkedforClosing = isMarkedforClosing;
	}
	public int getClosedBy() {
		return closedBy;
	}
	public void setClosedBy(int closedBy) {
		this.closedBy = closedBy;
	}
	public Date getClosedOn() {
		return closedOn;
	}
	public void setClosedOn(Date closedOn) {
		this.closedOn = closedOn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSeverityLevel() {
		return severityLevel;
	}
	public void setSeverityLevel(String severityLevel) {
		this.severityLevel = severityLevel;
	}
	public int compareTo(Bug bug) {
		// TODO Auto-generated method stub
		return this.severityLevel.compareToIgnoreCase(bug.getSeverityLevel());
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj==null)
			return false;
		else if(!(obj instanceof Bug))
			return false;
		Bug bug=(Bug)obj;
		if(this.getBugId()==bug.getBugId())
			return true;
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.bugId;
	}
	@Override
	public String toString() {
		return "{ bugId :" + bugId + ",title : " + title + ", description:" + description + ", pid:" + pid
				+ ", testerId:" + testerId + ", openDate:" + openDate + ", assignedto:" + assignedto
				+ ", isMarkedforClosing:" + isMarkedforClosing + ", closedBy:" + closedBy + ", closedOn :" + closedOn
				+ ", status:" + status + ", severityLevel:" + severityLevel + "}";
	}
	
}
