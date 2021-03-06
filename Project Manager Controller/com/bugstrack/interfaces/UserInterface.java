package com.bugstrack.interfaces;

import java.util.List;

import com.bugstrack.domain.User;

public interface UserInterface {
   void addUser(User user);
   User getUser(int userId);
   List<Integer> getAllUser();
   int lastrowAdded();
   void updatePassword(String emailId,String password);
   void updateLastLogin(String emailId);
   void registerUser(String emailId,String password);
   int getUserIdByemail(String emailId);
   void close();
}
