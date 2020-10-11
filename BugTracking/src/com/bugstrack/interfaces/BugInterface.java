package com.bugstrack.interfaces;

import java.util.List;

import com.bugstrack.domain.Bug;
import com.bugstrack.exceptions.AlreadyMarkedForClosing;
import com.bugstrack.exceptions.BugAlreadyClosedException;
import com.bugstrack.exceptions.BugAlreadyExistsException;
import com.bugstrack.exceptions.BugsNotFoundException;
import com.bugstrack.exceptions.CustomSQLException;
import com.bugstrack.exceptions.EmptyBugsListException;
import com.hsbc.db.dao.String;
import com.hsbc.db.exceptions.BugNotFoundException;
import com.hsbc.db.exceptions.NotMarkedClosedException;
import com.hsbc.db.exceptions.ProjectCannotBeAddedException;
import com.hsbc.db.exceptions.ProjectCompletedException;
import com.hsbc.db.exceptions.ProjectNotFoundException;

public interface BugInterface {
   void add(String projectName, Bug bug) throws BugAlreadyExistsException, CustomSQLException;
   void markforclosing(int bugId) throws AlreadyMarkedForClosing, BugsNotFoundException, CustomSQLException;
   void closeBug(Bug bug) throws BugAlreadyClosedException, CustomSQLException;
   List<Bug> getBugs(int pId) throws EmptyBugsListException;
   int lastrowAdded();
   boolean getIsMarkedforClosing(int bugId);
   void close();

}
