package com.bugstrack.domain;

public class Logs {
	private int logId;
	private String logName;
	private String description;
	private int CausedByUser;
	
	
	public Logs(int logId, String logName, String description, int causedByUser) {
		super();
		this.logId = logId;
		this.logName = logName;
		this.description = description;
		CausedByUser = causedByUser;
	}
	public Logs(String logName, String description, int causedByUser) {
		super();
		this.logName = logName;
		this.description = description;
		CausedByUser = causedByUser;
	}
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
	public String getLogName() {
		return logName;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCausedByUser() {
		return CausedByUser;
	}
	public void setCausedByUser(int causedByUser) {
		CausedByUser = causedByUser;
	}
	@Override
	public String toString() {
		return "Logs [logId=" + logId + ", logName=" + logName + ", description=" + description + ", CausedByUser="
				+ CausedByUser + "]";
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
