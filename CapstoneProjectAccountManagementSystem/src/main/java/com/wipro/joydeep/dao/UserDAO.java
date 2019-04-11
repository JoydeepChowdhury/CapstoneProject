package com.wipro.joydeep.dao;

import com.wipro.joydeep.model.UserDetails;

public interface UserDAO
       {
           public void createUser(UserDetails ud);
           public void deleteUser(String userName);
           public boolean deleteUserByCustomerId(String customerId);
       }
