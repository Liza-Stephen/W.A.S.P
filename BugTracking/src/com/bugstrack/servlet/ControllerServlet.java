package com.bugstrack.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bugstrack.domain.Project;
import com.bugstrack.factory.ForwardMethod;
import com.bugstrack.service.BugService;
import com.bugstrack.service.ProjectService;
import com.bugstrack.service.TeamService;
import com.bugstrack.service.UserImportService;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ControllerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BufferedReader reader=request.getReader();
		Object obj=null;
		try {
			obj=new JSONParser().parse(reader);
			System.out.println("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session=request.getSession(false);
		int userId=104;
		if(session==null)
		{
			userId=108;
			session=request.getSession(true);
			session.setAttribute("userId", userId);
		}
		else
		{
			userId=(Integer)session.getAttribute("userId");
		}
		System.out.println(userId);
		JSONObject json=(JSONObject)obj;
		
		String action=(String)json.get("action");
		System.out.println(action);
	    String res=null;
	    if(action.equalsIgnoreCase("importUser"))
	    {
	    	UserImportService.addUsers(json);
	    	System.out.println("success");
	    }
	    else if(action.equalsIgnoreCase("getTeam"))
	    {
	    	res=TeamService.getListofUser(userId);
	    }
	    else if(action.equalsIgnoreCase("addProject"))
		{
			System.out.println("Enter Add project ");
		ProjectService.parseJSON(json,userId);
		System.out.println("success"); // check success
		}
		else if(action.equalsIgnoreCase("getProject"))
		{
			System.out.println("Enter Get project ");
			res=ProjectService.sendJSON(userId);
			System.out.println(res);
		}
		else if(action.equalsIgnoreCase("getBugs"))
		{
			System.out.println("Enter Get bug ");
		    res=BugService.sendjson(userId);
			System.out.println(res);
		}
		else
		{
			System.out.println(json.toJSONString());
			res="success";
		}
		response.setStatus(200);
		//response.setContentType("application/json;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		pw.println(res);
		pw.close();
		// [{'pname:cdsnkjfnkl}]
	}

}
