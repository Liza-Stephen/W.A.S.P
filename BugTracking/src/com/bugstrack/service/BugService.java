package com.bugstrack.service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bugstrack.dao.BugDAO;
import com.bugstrack.dao.ProjectDAO;
import com.bugstrack.domain.Bug;
import com.bugstrack.factory.ForwardMethod;
import com.bugstrack.interfaces.BugInterface;
import com.bugstrack.interfaces.ProjectInterface;

public class BugService {
	 public static List<Bug> getBugSortable(int userId)
	    {
	    	List<Integer> pids=TeamService.getProjectIds(userId);
	    	List<Bug> bugs=new ArrayList<Bug>();
	    	BugInterface bugDao=new BugDAO();
	    	ProjectInterface pr=new ProjectDAO();
	    	for(int pid:pids)
	    	{
	    		if(pr.getStatus(pid).equalsIgnoreCase("open"))
	    		bugs.addAll(bugDao.getBugs(pid));
	    	}
	    	Collections.sort(bugs);
	    	return bugs;
	    }
	 public static List<Bug> getBugSortableByManager(int userId)
	    {
	    	List<Integer> pids=ProjectService.getProjectIdByUser(userId);
	    	List<Bug> bugs=new ArrayList<Bug>();
	    	BugInterface bugDao=ForwardMethod.getBugInterface();
	    	ProjectInterface pr=ForwardMethod.getProjectInterface();
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
		 StringWriter st=new StringWriter();
	        try {
				array.writeJSONString(st);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return st.toString();
	 }
}
