package com.wipro.joydeep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.joydeep.dao.UserDAO;
import com.wipro.joydeep.model.UserDetails;
@Service
@Transactional
public class UserDAOServiceImpl implements UserDAOService
{
    @Autowired
	UserDAO udao;
	
	public void createUser(UserDetails ud) {
		// TODO Auto-generated method stub
	   udao.createUser(ud);
	}
	
	public void deleteUser(String userName)
	{
		udao.deleteUser(userName);
	}

	@Override
	public boolean deleteUserByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		return udao.deleteUserByCustomerId(customerId);
	}

}
