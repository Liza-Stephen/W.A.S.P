package com.bugstrack.domain;

import java.sql.Timestamp;

public class Exceptions implements Comparable<Exceptions>{
	
	private int logId;
	private String logName;
	private int causedByUser;
	private Timestamp logtime;
	
	
	@Override
	public int hashCode() {
		return logId;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exceptions other = (Exceptions) obj;
		if (causedByUser != other.causedByUser)
			return false;
		if (logId != other.logId)
			return false;
		if (logName == null) {
			if (other.logName != null)
				return false;
		} else if (!logName.equals(other.logName))
			return false;
		if (logtime == null) {
			if (other.logtime != null)
				return false;
		} else if (!logtime.equals(other.logtime))
			return false;
		return true;
	}
	public Exceptions(int logId, String logName, int causedByUser, Timestamp logtime) {
		super();
		this.logId = logId;
		this.logName = logName;
		this.causedByUser = causedByUser;
		this.logtime = logtime;
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
	public int getCausedByUser() {
		return causedByUser;
	}
	public void setCausedByUser(int causedByUser) {
		this.causedByUser = causedByUser;
	}
	public Timestamp getLogtime() {
		return logtime;
	}
	public void setLogtime(Timestamp logtime) {
		this.logtime = logtime;
	}
	@Override
	public int compareTo(Exceptions o) {
		return this.logId - o.logId;
	}
	
	
	

}
