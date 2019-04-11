package com.wipro.joydeep.dao;

import java.util.List;

import com.wipro.joydeep.model.Account;

public interface AccountDAO 
      {
         public void assignAccountToACustomer(Account c,String customerId);
         public boolean deleteAccountFromACustomer(String accountId,String customerId);
         public List<Account> showAccountsOfACustomer(String customerId);
         public List<Account> getJsonForAllAccounts(String userName);
         public Account getAccountByAccountId(String accountId);
         public boolean updateAccount(Account a);
      }
