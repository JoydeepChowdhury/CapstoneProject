package com.wipro.joydeep.dao;

import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.joydeep.model.Account;

public interface NewAccountDAO 
{
	public Account getAccountDetailsById( String accountId);
	public boolean makeTransaction(String sourceAcno,String destAcno,double balance,String userName);
}
