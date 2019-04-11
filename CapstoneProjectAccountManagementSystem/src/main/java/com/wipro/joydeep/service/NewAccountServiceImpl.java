package com.wipro.joydeep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.joydeep.dao.NewAccountDAO;
import com.wipro.joydeep.model.Account;

@Service
@Transactional
public class NewAccountServiceImpl implements NewAccountService
{
   @Autowired
   private NewAccountDAO nad;
   
	@Override
	public Account getAccountDetailsById(String accountId) {
		// TODO Auto-generated method stub
		return nad.getAccountDetailsById(accountId);
	}

	@Override
	public boolean makeTransaction(String sourceAcno, String destAcno, double balance, String userName) {
		// TODO Auto-generated method stub
		return nad.makeTransaction(sourceAcno, destAcno, balance, userName);
	}
	
	
    
}
