package com.bugstrack.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bugstrack.dao.BugDAO;
import com.bugstrack.dao.BugDAOImpl;
import com.bugstrack.dao.ProjectDAO;
import com.bugstrack.dao.ProjectDAOImpl;
import com.bugstrack.dao.TeamDAO;
import com.bugstrack.dao.TeamDAOImpl;
import com.bugstrack.domain.Bug;
import com.bugstrack.domain.Project;
import com.bugstrack.domain.Team;

public class ProjectService {
    public static void addProject(Project p,List<Integer> teamMem)
    {
    	ProjectDAO pr=new ProjectDAOImpl();
    	pr.addProject(p);
    	TeamDAO tm=new TeamDAOImpl();
    	int pid=pr.lastrowAdded(); // to be replaced by max id find
    	for(int userId:teamMem)
    		tm.addTeam(new Team(userId, pid));
    	
    }
    public static List<Integer> getProjectIds(int userId)
    {
    	TeamDAO teamDao=new TeamDAOImpl();
    	List<Integer> pids=teamDao.getProjects(userId);
    	return pids;
    }
    public static List<Project> getProjectByUser(int userId)
    {
        List<Integer> pids=getProjectIds(userId);
    	ProjectDAO projectDao=new ProjectDAOImpl();
    	List<Project> projects=new ArrayList<Project>();
    	for(int pid:pids)
    		projects.add(projectDao.getProject(pid));
    	return projects;
    }
    public static String sendJSON(int userId)
    {
    	List<Project> projects=getProjectByUser(userId);
    	JSONArray array=new JSONArray();
    	JSONObject obj=null;
    	for(Project p:projects)
    	{
    		obj=new JSONObject();
    		obj.put("pid",p.getpId() );
    		obj.put("pName", p.getpName());
    		obj.put("description", p.getDescription());
    		obj.put("startDate", p.getStartDate());
    		obj.put("status", p.getStatus());
    		array.add(obj);
    	}
    	return array.toJSONString();
    }
    public static void parseJSON(JSONObject json)
    {
    	String pname=(String)json.get("pName");
		String description=(String)json.get("description");
		String tempDate=(String)json.get("startDate");
		Date startDate=Date.valueOf(tempDate);
		List<Integer> teamMem=new ArrayList<Integer>();
		JSONArray array=(JSONArray)json.get("userIds");
		for(Object o:array)
		{
			Long l=(Long)o;
			teamMem.add(l.intValue());
		}
		Project p=new Project(pname, description, startDate, "inProgress");
		addProject(p, teamMem);
    }
}
