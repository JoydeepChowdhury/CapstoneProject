package com.wipro.joydeep.service;

import com.wipro.joydeep.model.UserDetails;

public interface UserDAOService
{
	 public void createUser(UserDetails ud);
	 public void deleteUser(String userName);
	 public boolean deleteUserByCustomerId(String customerId);
}
