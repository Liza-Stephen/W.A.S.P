package com.hsbc.db.dao;


import com.hsbc.db.exceptions.BugNotFoundException;
import com.hsbc.db.exceptions.NotMarkedClosedException;
import com.hsbc.db.exceptions.ProjectCompletedException;
import com.hsbc.db.exceptions.ProjectNotFoundException;

public interface Dao {

	public void add(String name,String title,String desc,String date,String severity,int testerid) throws ProjectNotFoundException, ProjectCompletedException;
	public void MarkForClosing(int id) throws BugNotFoundException;
	public void CloseBug(int id,String date,int closedby) throws NotMarkedClosedException;
}
