package com.bugstrack.interfaces;

import java.util.List;

import com.bugstrack.domain.User;
import com.bugstrack.exceptions.UserAlreadyRegisteredException;
import com.bugstrack.exceptions.UserDoesNotExistException;
import com.bugstrack.exceptions.UserNotFoundException;

public interface UserInterface {
   void addUser(User user) throws UserDoesNotExistException;
   User getUser(int userId) throws UserDoesNotExistException;
   List<Integer> getAllUser();
   int lastrowAdded();
   void updatePassword(String emailId,String password);
   void updateLastLogin(String emailId);
   void registerUser(String emailId,String password) throws UserAlreadyRegisteredException, UserNotFoundException, UserDoesNotExistException;
   int getUserIdByemail(String emailId) throws UserNotFoundException;
   void close();
}
