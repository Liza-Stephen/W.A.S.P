package com.bugstrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bugstrack.db.DatabaseConnection;
import com.bugstrack.domain.Team;
import com.bugstrack.interfaces.TeamInterface;

public class TeamDAO implements TeamInterface {
    private Connection teamDao;
    
	public TeamDAO() {
		teamDao=DatabaseConnection.getConnection();
	}

	public void addTeam(Team team) {
		// TODO Auto-generated method stub
        String query ="insert into teams(userId,pid) values(?,?)";
        try {
			PreparedStatement ps=teamDao.prepareStatement(query);
			ps.setInt(1, team.getUserId());
			ps.setInt(2, team.getpId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Integer> getTeam(int pId) {
		// TODO Auto-generated method stub
		String query ="select userId from teams where pid=?";
		List<Integer> list=null;
		try {
			PreparedStatement ps=teamDao.prepareStatement(query);
			ps.setInt(1, pId);
			ResultSet rs=ps.executeQuery();
			list=new ArrayList<Integer>();
			while(rs.next())
			{
				int userId=rs.getInt(1);
				list.add(userId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// close();
		return list;
	}

	public List<Integer> getProjects(int userId) {
		// TODO Auto-generated method stub
		String query ="select pid from teams where userId=?";
		List<Integer> list=null;
		try {
			PreparedStatement ps=teamDao.prepareStatement(query);
			ps.setInt(1, userId);
			ResultSet rs=ps.executeQuery();
			list=new ArrayList<Integer>();
			while(rs.next())
			{
				int pId=rs.getInt(1);
				list.add(pId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	 close();
		return list;
	}
	public void close()
	{
		teamDao=null;
		DatabaseConnection.close();
	}

}
