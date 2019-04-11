package com.wipro.joydeep.service;

import com.wipro.joydeep.model.Account;

public interface NewAccountService {
	public Account getAccountDetailsById( String accountId);
	public boolean makeTransaction(String sourceAcno, String destAcno, double balance,String userName);
}
