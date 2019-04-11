package com.wipro.joydeep.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.joydeep.model.Account;
import com.wipro.joydeep.model.Customer;
import com.wipro.joydeep.model.UserDetails;

@Repository
public class UserLoginDAOImpl implements UserLoginDAO
      {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean checkLoginCredentials(UserDetails uds) {
		// TODO Auto-generated method stub
		boolean status=false;
		Session session=sessionFactory.getCurrentSession();
		List<UserDetails> udets=session.createCriteria(UserDetails.class).list();
		System.out.println(udets);
		for(UserDetails ud:udets)
		   {
			   if(ud.getUserName().equals(uds.getUserName())&&ud.getPassword().equals(uds.getPassword()))
			   {
				   status=true;
				   break;
			   }
		   }
		return status;
	}

	
	public Customer getCustomerDetails(UserDetails uds) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Customer custom = null;
		List<UserDetails> udets=session.createCriteria(UserDetails.class).list();
		System.out.println(udets);
		for(UserDetails ud:udets)
		   {
		        if(ud.getUserName().equals(uds.getUserName()))
		        		{
		        	      custom=ud.getCustomer();
		        	      break;
		        		}
		   }
		return custom;
	}
	
	public Customer getCustomerDetailsByUsername(String userName) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Customer custom = null;
		List<UserDetails> udets=session.createCriteria(UserDetails.class).list();
		System.out.println(udets);
		for(UserDetails ud:udets)
		   {
		        if(ud.getUserName().equals(userName))
		        		{
		        	      custom=ud.getCustomer();
		        	      break;
		        		}
		   }
		return custom;
	}
	
	public List<Account> getAccountsByUserName(String userName)
	{
		Session session=sessionFactory.getCurrentSession();
		Customer custom=null;
		List<Account> accounts=null;
		List<UserDetails> udets=session.createCriteria(UserDetails.class).list();
		System.out.println(udets);
		for(UserDetails ud:udets)
		   {
		        if(ud.getUserName().equals(userName))
		        		{
		        	      custom=ud.getCustomer();
		        	      break;
		        		}
		   }
		accounts=custom.getAccounts();
		return accounts;
	}

	
	
           
      }
