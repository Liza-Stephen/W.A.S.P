package com.bugstrack.factory;

import java.awt.image.BufferedImage;

import com.bugstrack.dao.BugDAO;
import com.bugstrack.dao.ProjectDAO;
import com.bugstrack.dao.RolesDAO;
import com.bugstrack.dao.TeamDAO;
import com.bugstrack.dao.UserDAO;
import com.bugstrack.interfaces.BugInterface;
import com.bugstrack.interfaces.ProjectInterface;
import com.bugstrack.interfaces.RolesInterface;
import com.bugstrack.interfaces.TeamInterface;
import com.bugstrack.interfaces.UserInterface;

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
}
