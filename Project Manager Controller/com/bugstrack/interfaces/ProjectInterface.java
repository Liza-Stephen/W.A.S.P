package com.bugstrack.interfaces;

import java.util.List;

import com.bugstrack.domain.Project;

public interface ProjectInterface {
	void addProject(Project p);
	Project getProject(int pid);
	String getStatus(int pid);
	List<Project> getAllProject();
	void updateStatus(int pid,String status);
	int lastrowAdded();
	void close();
}
