package com.bugstrack.service;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.Role;

import org.json.simple.JSONArray;

import com.bugstrack.dao.TeamDAO;
import com.bugstrack.domain.Project;
import com.bugstrack.domain.Roles;
import com.bugstrack.factory.ForwardMethod;
import com.bugstrack.interfaces.ProjectInterface;
import com.bugstrack.interfaces.RolesInterface;
import com.bugstrack.interfaces.TeamInterface;
import com.bugstrack.interfaces.UserInterface;

public class TeamService {
	public static List<Integer> getAllUsers()
	{
		UserInterface users=ForwardMethod.getUserInterface();
	    List<Integer> allusers=users.getAllUser();
		return allusers;
	}
	public static List<Integer> getTeamMembers(int pid)
	{
		TeamInterface teams=ForwardMethod.getTeamInterface();
		List<Integer> team=teams.getTeam(pid);
		return team;
	}
	public static List<Integer> getProjectIds(int userId) //get projects by user
    {
    	TeamInterface teamDao=ForwardMethod.getTeamInterface();
    	List<Integer> pids=teamDao.getProjects(userId);
    	return pids;
    }
	public static List<Integer> removeTester(List<Integer> testers,int manager)
	{
		List<Integer> openpids=new ArrayList<Integer>();
		for(int tester:testers)
		{
			List<Integer> pids=TeamService.getProjectIds(tester);
			openpids.clear();
    		for(int pid:pids)
    		{
    			if(ProjectService.getStatus(pid).equalsIgnoreCase("open"))
					{
						openpids.add(pid);
					}
    		}
    		if(openpids.size()>1)
    			testers.remove(tester);
    		else if(openpids.size()==1&&ProjectService.getManager(openpids.get(0))!=manager)
    			testers.remove(tester);
		}
		return testers;
	}
    public static List<Integer> removeDevelopers(List<Integer> allusers)
    {
       
    	for(int developer:allusers)
    	{
    		List<Integer> pids=TeamService.getProjectIds(developer);
    		for(int pid:pids)
    		{
    			if(ProjectService.getStatus(pid).equalsIgnoreCase("open"))
					{
						allusers.remove(developer);
						break;
					}
    		}

    	}
    	return allusers;
    }
	public static String getListofUser(int userId)
	{
		List<Integer> allusers=RoleService.getUserByRole("developer");
	    List<Integer> testers=RoleService.getUserByRole("tester");
	    allusers=removeDevelopers(allusers);
	    testers=removeTester(testers, userId);
	    allusers.addAll(testers);
	    JSONArray array=new JSONArray();
	    for(int user:allusers)
	    	array.add(user);
		return array.toJSONString();
	}
}
