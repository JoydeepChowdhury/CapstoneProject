package com.wipro.joydeep.dao;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.joydeep.model.Account;
import com.wipro.joydeep.model.TransferDetails;

@Repository
public class NewAccountDAOImpl implements NewAccountDAO
       {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Account getAccountDetailsById(String accountId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Account a=session.get(Account.class,accountId);
		return a;
	}

	@Override
	public boolean makeTransaction(String sourceAcno, String destAcno, double balance,String userName) {
		// TODO Auto-generated method stub
		System.out.println("hi");
		Session session=sessionFactory.getCurrentSession();
		Account source=session.get(Account.class,sourceAcno);
		Account destnation=session.get(Account.class,destAcno);
		source.setBalance(source.getBalance()-balance);
		destnation.setBalance(destnation.getBalance()+balance);
		session.save(source);
		session.save(destnation);
		TransferDetails tds=new TransferDetails();
		tds.setSourceAccountNo(sourceAcno);
		tds.setDestinationAccountNo(destAcno);
		tds.setTransactionTime(LocalDateTime.now());
		tds.setUserName(userName);
		tds.setAmount(balance);
		session.save(tds);
		return true;
	}

       }
