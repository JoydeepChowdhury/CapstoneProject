package com.wipro.joydeep.dao;

import java.util.List;

import com.wipro.joydeep.model.Customer;

public interface CustomerDAO
       {
             public void addNewCustomer(Customer customer);
             public boolean deleteCustomer(String customerId);
             public List<Customer> getCustomersList();
             public Customer getDetailsByCustomerId(String customerId);
             public boolean updateCustomer(Customer customer);
             
       }
