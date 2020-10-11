package com.bugstrack.interfaces;

import java.util.List;

import com.bugstrack.exceptions.RoleDoesNotExistException;

public interface RolesInterface {
   void addRoles(int userId,String role) throws RoleDoesNotExistException;
   String getRole(int userId);
   List<Integer> getUserByRole(String role) throws RoleDoesNotExistException;
}
