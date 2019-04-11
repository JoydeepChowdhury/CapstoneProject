package com.wipro.joydeep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.joydeep.dao.CustomerDAO;
import com.wipro.joydeep.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService
       {
    @Autowired
	CustomerDAO customerdao;
	
	

@Transactional
	public void addNewCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerdao.addNewCustomer(customer);
		
	}


@Transactional
	public boolean deleteCustomer(String customerId) {
		// TODO Auto-generated method stub
		return customerdao.deleteCustomer(customerId);
		
	}

@Transactional
public List<Customer> getCustomersList()
{
	return customerdao.getCustomersList();
}

@Transactional
@Override
public Customer getDetailsByCustomerId(String customerId) {
	// TODO Auto-generated method stub
	return customerdao.getDetailsByCustomerId(customerId);
}

@Transactional
@Override
public boolean updateCustomer(Customer customer) {
	// TODO Auto-generated method stub
	return customerdao.updateCustomer(customer);
}
           
       }
