package com.bugstrack.dao;

import java.util.List;

import com.bugstrack.domain.Bug;

public interface BugDAO {
   void add(Bug bug);
   void markforclosing(int bugId);
   void closeBug(int bugId);
   List<Bug> getBugs(int pId);
   int lastrowAdded();
   boolean getIsMarkedforClosing(int bugId);
}
