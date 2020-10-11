package com.bugstrack.interfaces;

import java.util.List;

public interface RolesInterface {
   void addRoles(int userId,String role);
   String getRole(int userId);
   List<Integer> getUserByRole(String role);
}
