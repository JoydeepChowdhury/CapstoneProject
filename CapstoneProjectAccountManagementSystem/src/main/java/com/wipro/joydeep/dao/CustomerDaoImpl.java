package com.wipro.joydeep.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.joydeep.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDAO
{
	@Autowired 
	private SessionFactory sessionFactory;


	public void addNewCustomer(Customer customer) {
		// TODO Auto-generated method stub
		try
		{
		Session session=sessionFactory.getCurrentSession();
		session.save(customer);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		/*
		 * Transaction tr=session.beginTransaction(); if(!tr.isActive()) { try {
		 * tr.begin(); session.save(customer); tr.commit();session.close();
		 * 
		 * } catch(Exception e) { e.printStackTrace(); tr.rollback();session.close(); }
		 * }
		 */
		 
	}

	public boolean deleteCustomer(String customerId) {
		// TODO Auto-generated method stub
		try
		{
		Session session=sessionFactory.getCurrentSession();
		Customer customer=session.get(Customer.class,customerId);
		session.delete(customer);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Customer> getCustomersList() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		 List<Customer> customers=session.createCriteria(Customer.class).list();
		 System.out.println(customers);
		 return customers;
	}

	@Override
	public Customer getDetailsByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		String hsql="from Customer where customerId='"+customerId+"'";
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(hsql);
		Customer custom=(Customer)query.list().get(0);
		System.out.println(custom);
		return custom;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		try
		{
		Session session=sessionFactory.getCurrentSession();
		session.update(customer);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

}
