package com.wasp.interfaces;

import java.util.List;

import com.bugstrack.domain.Team;

public interface TeamDAO {
	void addTeam(Team team);
	List<Integer> getTeam(int pId);
	List<Integer> getProjects(int userId);
}
