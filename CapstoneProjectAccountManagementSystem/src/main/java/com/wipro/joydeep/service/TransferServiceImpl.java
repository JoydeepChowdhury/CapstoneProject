package com.wipro.joydeep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.joydeep.dao.TransferDAO;
import com.wipro.joydeep.model.TransferDetails;

@Service
@Transactional
public class TransferServiceImpl implements TransferService
      {
	@Autowired
	private TransferDAO td;
	
	
	public List<TransferDetails> getTransferDetails(String userName)
	{
	    return td.getTransferDetails(userName);	
	}


	@Override
	public List<TransferDetails> getTransferDetailsByDate(String userName, String fromDate, String toDate) {
		// TODO Auto-generated method stub
		return td.getTransferDetailsByDate(userName, fromDate, toDate);
	}
	
	
	
      }
