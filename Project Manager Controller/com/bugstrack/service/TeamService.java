package com.bugstrack.service;

import java.util.List;

import com.bugstrack.domain.Project;
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
	public static List<Integer> removeManagers(List<Integer> allusers,int userId)
	{
		RolesInterface roles=ForwardMethod.getRoleInterface();
		for(int user:allusers)
		{
			List<String> role=roles.getRole(user);
			if(user!=userId)
				{
				for(String r:role)
					if(r.equalsIgnoreCase("manager"))
					{
						allusers.remove(user);
						break;
				}
				}
				
		}
		return allusers;
	}
    public static List<Integer> removeDevelopers(List<Integer> allusers)
    {
    	TeamInterface team=ForwardMethod.getTeamInterface();
    	ProjectInterface project=ForwardMethod.getProjectInterface();
    	RolesInterface roles=ForwardMethod.getRoleInterface();
    	for(int user:allusers)
    	{
    		List<String> role=roles.getRole(user);
    		for(String r:role)
    		{
    			if(r.equalsIgnoreCase("developer"))
    			{
    				List<Integer> list=team.getProjects(user);
    				for(int l:list)
    				{
    					if(project.getStatus(l).equalsIgnoreCase("open"))
    					{
    						allusers.remove(user);
    						break;
    					}
    				}
    				break;
    			}
    		}
    	}
    	return allusers;
    }
	public static String getListofUser(int userId)
	{
		List<Integer> allusers=getAllUsers();
	    allusers=removeManagers(allusers, userId);
	    
		return null;
	}
}
