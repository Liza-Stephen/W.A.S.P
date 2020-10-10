package com.bugstrack.dao;

import java.util.List;

import com.bugstrack.domain.Project;

public interface ProjectDAO {
	void addProject(Project p);
	Project getProject(int pid);
	String getStatus(int pid);
	List<Project> getAllProject();
	void updateStatus(int pid,String status);
	int lastrowAdded();
	
}
