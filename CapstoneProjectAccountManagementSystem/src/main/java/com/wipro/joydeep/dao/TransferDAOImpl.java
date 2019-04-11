package com.wipro.joydeep.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.joydeep.model.TransferDetails;

@Repository
public class TransferDAOImpl implements TransferDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<TransferDetails> getTransferDetails(String userName) {
		// TODO Auto-generated method stub
		
		 Session session = sessionFactory.getCurrentSession(); List<TransferDetails>
		 alllist=session.createCriteria(TransferDetails.class).list();
		 List<TransferDetails>
		 fillist=alllist.stream().filter(td->td.getUserName().equals(userName)).
		 collect(Collectors.toList());
		 
		
		
		return fillist;
	}

	@Override
	public List<TransferDetails> getTransferDetailsByDate(String userName, String fromDate, String toDate) {
		// TODO Auto-generated method stub
		 Session session=sessionFactory.openSession();
		 System.out.println(fromDate);
		 System.out.println(toDate);
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");
		 DateTimeFormatter dbFormatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
		 LocalDate fromLocalDate=LocalDate.parse(fromDate, formatter);
		 LocalDate toLocalDate=LocalDate.parse(toDate, formatter);
		 System.out.println(fromLocalDate);
		 System.out.println(toLocalDate);
		 String hql="from TransferDetails td where td.userName='"+userName+"' and td.transactionTime>='"+fromLocalDate.format(dbFormatter)+"' and td.transactionTime<='"+toLocalDate.format(dbFormatter)+"'";
		 Query query = session.createQuery(hql);
		 List<TransferDetails> results = query.list();
		 return results;
	}

}
