package com.wipro.joydeep.dao;

import java.util.List;

import com.wipro.joydeep.model.TransferDetails;

public interface TransferDAO {
    public List<TransferDetails> getTransferDetails(String userName);
    public List<TransferDetails> getTransferDetailsByDate(String userName,String fromDate,String toDate);
}
