package com.bugstrack.interfaces;

import java.util.List;

import com.bugstrack.domain.Bug;

public interface BugInterface {
   void add(Bug bug);
   void markforclosing(int bugId);
   void closeBug(int bugId);
   List<Bug> getBugs(int pId);
   int lastrowAdded();
   boolean getIsMarkedforClosing(int bugId);
   void close();
}
