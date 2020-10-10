package com.bugstrack.interfaces;

import java.util.List;

import com.bugstrack.domain.Team;

public interface TeamInterface {
	void addTeam(Team team);
	List<Integer> getTeam(int pId);
	List<Integer> getProjects(int userId);
	void close();
}
