package com.wipro.joydeep.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.joydeep.model.Customer;
import com.wipro.joydeep.model.UserDetails;


@Repository
public class UserDAOImpl implements UserDAO
      {

	@Autowired
	private SessionFactory sessionfactory;
	
	public void createUser(UserDetails ud) {
		Session session=sessionfactory.getCurrentSession();
		System.out.println(ud);
		session.save(ud);
		
	}

	@Override
	public void deleteUser(String userName) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.getCurrentSession();
		 List<UserDetails> uds=session.createCriteria(UserDetails.class).list();
		 UserDetails uf=null;
		 for(UserDetails u: uds)
		 {
			 if(u.getUserName().equals(userName))
			 {
				 uf=u;
				 break;
			 }
		 }
		 System.out.println(uf);
		session.delete(uf);
	}

	@Override
	public boolean deleteUserByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		try
		{
		Session session=sessionfactory.getCurrentSession();
		List<UserDetails> uds=session.createCriteria(UserDetails.class).list();
		UserDetails utbd=null;
		for(UserDetails user: uds)
		   {
			   if(user.getCustomer().getCustomerId().equals(customerId))
			   {
				   utbd=user;
			   }
		   }
		session.delete(utbd);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
           
      }
