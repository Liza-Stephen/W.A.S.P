package com.bugstrack.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bugstrack.dao.BugDAO;
import com.bugstrack.dao.BugDAOImpl;
import com.bugstrack.dao.ProjectDAO;
import com.bugstrack.dao.ProjectDAOImpl;
import com.bugstrack.domain.Bug;

public class BugService {
	 public static List<Bug> getBugSortable(int userId)
	    {
	    	List<Integer> pids=ProjectService.getProjectIds(userId);
	    	List<Bug> bugs=new ArrayList<Bug>();
	    	BugDAO bugDao=new BugDAOImpl();
	    	ProjectDAO pr=new ProjectDAOImpl();
	    	for(int pid:pids)
	    	{
	    		if(pr.getStatus(pid).equalsIgnoreCase("open"))
	    		bugs.addAll(bugDao.getBugs(pid));
	    	}
	    	Collections.sort(bugs);
	    	return bugs;
	    }
	 public static String sendjson(int userId)
	 {
		 List<Bug> bugs=getBugSortable(userId);
		 JSONArray array=new JSONArray();
		 JSONObject obj=null;
		 for(Bug b:bugs)
		 {
			 obj=new JSONObject();
			 obj.put("bugId", b.getBugId());
			 obj.put("title", b.getTitle());
			 array.add(obj);
		 }
		 return array.toJSONString();
	 }
}
