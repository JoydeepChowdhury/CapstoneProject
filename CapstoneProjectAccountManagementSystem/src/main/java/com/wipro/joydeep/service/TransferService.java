package com.wipro.joydeep.service;

import java.util.List;

import com.wipro.joydeep.model.TransferDetails;

public interface TransferService {
   
	public List<TransferDetails> getTransferDetails(String userName);
	public List<TransferDetails> getTransferDetailsByDate(String userName, String fromDate, String toDate);
}
