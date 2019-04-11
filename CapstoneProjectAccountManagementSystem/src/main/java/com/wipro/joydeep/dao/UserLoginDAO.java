package com.wipro.joydeep.dao;

import java.util.List;

import com.wipro.joydeep.model.Account;
import com.wipro.joydeep.model.Customer;
import com.wipro.joydeep.model.UserDetails;

public interface UserLoginDAO 
      {
         public boolean checkLoginCredentials(UserDetails uds);
         public Customer getCustomerDetails(UserDetails uds);
         public Customer getCustomerDetailsByUsername(String userName);
         public List<Account> getAccountsByUserName(String userName);
      }
