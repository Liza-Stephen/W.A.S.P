package com.wasp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wasp.exceptions.UnknownActionTriggeredException;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Handle All Of The Post Requests Below By Checking The Action Parameter
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("register")) {
			//Forward request to register class
		}
		else if(action.equalsIgnoreCase("login")) {
			//Forward the request for login class
		}
		else if(action.equalsIgnoreCase("importUser")) {
			//Forward the request for importing user into the database.
		}
		else if(action.equalsIgnoreCase("displayProjects")) {
			//Forward the request for displaying the list of projects a user is working on
		}
		else if(action.equalsIgnoreCase("assignBugs")) {
			//Forward the request for assigning bug to a developer by the manager
		}
		else if(action.equalsIgnoreCase("markBugForClosing")) {
			//Forward the request for marking a bug for closing by the developer
		}
		else if(action.equalsIgnoreCase("reportBug")) {
			//Forward the request for reporting the bug by the tester
		}
		else if(action.equalsIgnoreCase("displayBugList")) {
			//Forward the request for fetching the bug list fetched from composite unique userid and projectid.
		}
		else if(action.equalsIgnoreCase("createNewProject")) {
			//Forward the request for creating a new project by the manager
		}
		else if(action.equalsIgnoreCase("closeBug")) {
			//Forward the request for closing the bug by the manager
		}
		else {
			//Handle unknown request from the front-end and log this in the exception table.
			//Dispatch request to a class that handles this exception.
//			throw new UnknownActionTriggeredException(userid, log)
		}
		
		
		
		
		
		
		
		
	}

}
