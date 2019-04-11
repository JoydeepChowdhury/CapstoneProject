package com.wipro.joydeep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.joydeep.dao.UserLoginDAO;
import com.wipro.joydeep.model.Account;
import com.wipro.joydeep.model.Customer;
import com.wipro.joydeep.model.UserDetails;

@Service
@Transactional
public class UserLoginServiceImpl implements UserLoginService
{
    @Autowired
	UserLoginDAO uld;
	
	
	public boolean checkLoginCredentials(UserDetails uds) {
		// TODO Auto-generated method stub
		return uld.checkLoginCredentials(uds);
	}


	
	public Customer getCustomerDetails(UserDetails uds) {
		// TODO Auto-generated method stub
		return uld.getCustomerDetails(uds);
	}
	
	public Customer getCustomerDetailsByUsername(String userName)
	{
		return uld.getCustomerDetailsByUsername(userName);
	}



	
	public List<Account> getAccountsByUserName(String userName) {
		// TODO Auto-generated method stub
		return uld.getAccountsByUserName(userName);
	}




     
}
