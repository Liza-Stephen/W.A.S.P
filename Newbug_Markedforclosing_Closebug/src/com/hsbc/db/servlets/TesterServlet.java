package com.hsbc.db.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.db.dao.BugDao;
import com.hsbc.db.dao.Dao;
import com.hsbc.db.dao.DaoFactory;
import com.hsbc.db.domain.Bug;
import com.hsbc.db.exceptions.ProjectCompletedException;
import com.hsbc.db.exceptions.ProjectNotFoundException;

public class TesterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException {
		String nameofp=request.getParameter("pname");
		String title1=request.getParameter("title");
		String date=request.getParameter("start");
		String desc1=request.getParameter("desc");
		String severity1=request.getParameter("level");
		String id=request.getParameter("testerid");
		int testerid=Integer.parseInt(id);
		
		Dao d= DaoFactory.getDao("Bug");
		try {
			d.add(nameofp, title1, desc1, date, severity1,testerid);
		} catch (ProjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProjectCompletedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
