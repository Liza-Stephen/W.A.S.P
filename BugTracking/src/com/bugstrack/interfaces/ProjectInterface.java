package com.bugstrack.interfaces;

import java.util.List;

import com.bugstrack.domain.Project;
import com.bugstrack.exceptions.ProjectAlreadyAddedException;
import com.bugstrack.exceptions.ProjectDoesNotExistExeption;
import com.bugstrack.exceptions.UserDoesNotExistException;

public interface ProjectInterface {
	void addProject(Project p) throws ProjectAlreadyAddedException;
	Project getProject(int pid) throws ProjectDoesNotExistExeption;
	String getStatus(int pid);
	List<Project> getAllProject();
	void updateStatus(int pid,String status);
	int lastrowAdded();
	List<Integer> getAllProjectByManager(int manager);
	void close();
	int getManager(int pid) throws UserDoesNotExistException;
}
