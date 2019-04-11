package com.wipro.joydeep.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.joydeep.model.Account;
import com.wipro.joydeep.model.Customer;
import com.wipro.joydeep.model.UserDetails;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Autowired
	private SessionFactory sessionfactory;
	
	public void assignAccountToACustomer(Account c, String customerId) {
		try
		{
		Session session=sessionfactory.getCurrentSession();
		Customer customer=session.get(Customer.class,customerId);
		List<Account> accounts;
		System.out.println(customer);
		System.out.println(c);
		System.out.println("hi I am here");
		if(customer.getAccounts()==null)
		{
			accounts=new ArrayList<Account>();
		}
		else
		{
			accounts=customer.getAccounts();
		}
		accounts.add(c);
		customer.setAccounts(accounts);
		session.save(customer);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public List<Account> showAccountsOfACustomer(String customerId)
	{
		Session session=sessionfactory.getCurrentSession();
		Customer cust=session.get(Customer.class,customerId);
	    List<Account> accounts=cust.getAccounts();
	 // System.out.println(accounts);
	    return accounts;
	}
	
	
	public boolean deleteAccountFromACustomer(String accountId, String customerId) {
		// TODO Auto-generated method stub
		try
		{
		Session session=sessionfactory.getCurrentSession();
		Account account=session.get(Account.class,accountId);
		Customer customer=session.get(Customer.class, customerId);
		List<Account> accounts=customer.getAccounts();
		accounts.remove(account);
		customer.setAccounts(accounts);
		session.save(customer);
		session.delete(account);
		return true;
		}
		catch(Exception se)
		{
			se.printStackTrace();
			return false;
		}
	}
	
	public List<Account> getJsonForAllAccounts(String userName)
	{
		Session session=sessionfactory.getCurrentSession();
		List<UserDetails> users=session.createCriteria(UserDetails.class).list();
		UserDetails req=null;
		for(UserDetails u : users)
		{
			if(u.getUserName().equals(userName))
			{
				req=u;
				break;
			}
		}
		return req.getCustomer().getAccounts();
		
	}

	@Override
	public Account getAccountByAccountId(String accountId) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.getCurrentSession();
		Account account=session.get(Account.class,accountId);
		return account;
	}

	@Override
	public boolean updateAccount(Account a) {
		// TODO Auto-generated method stub
		
		  try { Session session=sessionfactory.getCurrentSession(); session.update(a);
		 return true; } catch(Exception e) { return false; }
		 

	}

}
