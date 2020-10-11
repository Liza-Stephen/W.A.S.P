package com.bugstrack.factory;


import com.bugstrack.dao.BugDAO;
import com.bugstrack.dao.ProjectDAO;
import com.bugstrack.dao.RolesDAO;
import com.bugstrack.dao.TeamDAO;
import com.bugstrack.dao.UserDAO;
import com.bugstrack.dao.UserLoggedInDAO;
import com.bugstrack.interfaces.BugInterface;
import com.bugstrack.interfaces.ProjectInterface;
import com.bugstrack.interfaces.RolesInterface;
import com.bugstrack.interfaces.TeamInterface;
import com.bugstrack.interfaces.UserInterface;
import com.bugstrack.interfaces.UserLoggedInInterface;

public class ForwardMethod {
  public static ProjectInterface getProjectInterface()
  {
	  return new ProjectDAO();
  }
  public static TeamInterface getTeamInterface()
  {
	  return new TeamDAO();
  }
  public static UserInterface getUserInterface()
  {
	  return new UserDAO();
  }
  public static BugInterface getBugInterface() {
	return new BugDAO();
   }
  public static RolesInterface getRoleInterface()
  {
	  return new RolesDAO();
  }
  
  public static UserLoggedInInterface getUserLoggedInInterface() {
	  return new UserLoggedInDAO();
  }
}
