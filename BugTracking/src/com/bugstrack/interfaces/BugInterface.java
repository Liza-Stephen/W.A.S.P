package com.bugstrack.interfaces;

import java.util.List;

import com.bugstrack.domain.Bug;
import com.bugstrack.exceptions.AlreadyMarkedForClosing;
import com.bugstrack.exceptions.BugAlreadyClosedException;
import com.bugstrack.exceptions.BugAlreadyExistsException;
import com.bugstrack.exceptions.EmptyBugsListException;

public interface BugInterface {
   void add(Bug bug) throws BugAlreadyExistsException;
   void markforclosing(int bugId) throws AlreadyMarkedForClosing;
   void closeBug(int bugId) throws BugAlreadyClosedException;
   List<Bug> getBugs(int pId) throws EmptyBugsListException;
   int lastrowAdded();
   boolean getIsMarkedforClosing(int bugId);
   void close();
}
