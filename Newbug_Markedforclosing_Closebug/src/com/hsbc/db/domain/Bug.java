package com.hsbc.db.domain;

import java.sql.Date;

public class Bug {

	private int bugid;
	private String title;
	private String description;
	private int pid;
	private int testerid;
	private Date opendate;
	private int assignedto;
	private boolean ismarkedforclosing;
	private int closedby;
	private int closedon;
	private String status;
	private String severitylevel;
	public Bug() {
		super();
		this.bugid = bugid;
		this.title = title;
		this.description = description;
		this.pid = pid;
		this.testerid = testerid;
		this.opendate = opendate;
		this.assignedto = assignedto;
		this.ismarkedforclosing = ismarkedforclosing;
		this.closedby = closedby;
		this.closedon = closedon;
		this.status = status;
		this.severitylevel = severitylevel;
	}
	public int getBugid() {
		return bugid;
	}
	public void setBugid(int bugid) {
		this.bugid = bugid;
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
	public int getTesterid() {
		return testerid;
	}
	public void setTesterid(int testerid) {
		this.testerid = testerid;
	}
	public Date getOpendate() {
		return opendate;
	}
	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}
	public int getAssignedto() {
		return assignedto;
	}
	public void setAssignedto(int assignedto) {
		this.assignedto = assignedto;
	}
	public boolean isIsmarkedforclosing() {
		return ismarkedforclosing;
	}
	public void setIsmarkedforclosing(boolean ismarkedforclosing) {
		this.ismarkedforclosing = ismarkedforclosing;
	}
	public int getClosedby() {
		return closedby;
	}
	public void setClosedby(int closedby) {
		this.closedby = closedby;
	}
	public int getClosedon() {
		return closedon;
	}
	public void setClosedon(int closedon) {
		this.closedon = closedon;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSeveritylevel() {
		return severitylevel;
	}
	public void setSeveritylevel(String severitylevel) {
		this.severitylevel = severitylevel;
	}
	@Override
	public String toString() {
		return "Bug [bugid=" + bugid + ", title=" + title + ", description=" + description + ", pid=" + pid
				+ ", testerid=" + testerid + ", opendate=" + opendate + ", assignedto=" + assignedto
				+ ", ismarkedforclosing=" + ismarkedforclosing + ", closedby=" + closedby + ", closedon=" + closedon
				+ ", status=" + status + ", severitylevel=" + severitylevel + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + assignedto;
		result = prime * result + bugid;
		result = prime * result + closedby;
		result = prime * result + closedon;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (ismarkedforclosing ? 1231 : 1237);
		result = prime * result + ((opendate == null) ? 0 : opendate.hashCode());
		result = prime * result + pid;
		result = prime * result + ((severitylevel == null) ? 0 : severitylevel.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + testerid;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Bug other = (Bug) obj;
		if (assignedto != other.assignedto)
			return false;
		if (bugid != other.bugid)
			return false;
		if (closedby != other.closedby)
			return false;
		if (closedon != other.closedon)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (ismarkedforclosing != other.ismarkedforclosing)
			return false;
		if (opendate == null) {
			if (other.opendate != null)
				return false;
		} else if (!opendate.equals(other.opendate))
			return false;
		if (pid != other.pid)
			return false;
		if (severitylevel == null) {
			if (other.severitylevel != null)
				return false;
		} else if (!severitylevel.equals(other.severitylevel))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (testerid != other.testerid)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
}
