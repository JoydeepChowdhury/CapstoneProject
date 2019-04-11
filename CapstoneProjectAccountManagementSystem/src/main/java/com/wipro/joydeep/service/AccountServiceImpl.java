package com.wipro.joydeep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.joydeep.dao.AccountDAO;
import com.wipro.joydeep.model.Account;
@Service
@Transactional
public class AccountServiceImpl implements AccountService  
{
   @Autowired
	AccountDAO ad;
	public void assignAccountToACustomer(Account c, String customerId) {
	     ad.assignAccountToACustomer(c, customerId);
		
	}

    
	public boolean deleteAccountFromACustomer(String accountId, String customerId) {
		// TODO Auto-generated method stub
		return ad.deleteAccountFromACustomer(accountId, customerId);
	}


	
	public List<Account> showAccountsOfACustomer(String customerId) {
		// TODO Auto-generated method stub
		return ad.showAccountsOfACustomer(customerId);
	}
    
	public List<Account> getJsonForAllAccounts(String userName)
	{
		return ad.getJsonForAllAccounts(userName);
	}


	@Override
	public Account getAccountByAccountId(String accountId) {
		// TODO Auto-generated method stub
		return ad.getAccountByAccountId(accountId);
	}


	@Override
	public boolean updateAccount(Account a) {
		// TODO Auto-generated method stub
		return ad.updateAccount(a);
	}
}
