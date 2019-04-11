package com.wipro.joydeep.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipro.joydeep.model.Account;
import com.wipro.joydeep.model.ResponseClass;
import com.wipro.joydeep.service.AccountService;
import com.wipro.joydeep.service.NewAccountService;
import com.wipro.joydeep.service.UserLoginService;

@RestController
public class AccountController
{
	@Autowired
	AccountService as;
	
	  @Autowired       
	   	UserLoginService uls;
	
	  @Autowired
		private NewAccountService nas;
	
	@RequestMapping(value="/add-account/{customerId}",consumes=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.POST)
    public void addAccountToACustomer(@RequestBody Account a,@PathVariable String customerId)
    {
    	as.assignAccountToACustomer(a, customerId);
    }
	
	@RequestMapping(value="/delete-account/{accountId}/{customerId}",method=RequestMethod.DELETE)
	public void deleteAccountFromACustomer(@PathVariable String accountId,@PathVariable String customerId)
	{
		as.deleteAccountFromACustomer(accountId, customerId);
	}
	
	@RequestMapping(value="accounts/{customerId}",method=RequestMethod.GET)
	public List<Account> getAccountsOfACustomer(@PathVariable String customerId)
	{
		return as.showAccountsOfACustomer(customerId);
	}
	
	@RequestMapping(value="/get-account-details-for-funds-transfer",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public String getJsonForAllAccounts(HttpServletRequest request)
	{
		String userName=request.getSession().getAttribute("userName").toString();
		List<Account> accounts=as.getJsonForAllAccounts(userName);
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
	    final ObjectMapper mapper = new ObjectMapper();

	    try {
			mapper.writeValue(out, accounts);
			final byte[] data = out.toByteArray();
		    return new String(data);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	    
	}
	
  @RequestMapping(value="/transfer-funds-new",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
  public String transferfunds(@RequestParam String from_acc_no, @RequestParam String to_acc_no, @RequestParam String balance,ModelMap model,HttpServletRequest request)
  {
	  boolean status=nas.makeTransaction(from_acc_no,to_acc_no,Double.parseDouble(balance),request.getSession().getAttribute("userName").toString());
	  ResponseClass rc=null;
	  if(status==true)
	 {
		 rc=new ResponseClass("success");
	 }
	 else
	 {
		 rc=new ResponseClass("failure");
	 }
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
	    final ObjectMapper mapper = new ObjectMapper();
	    try {
			mapper.writeValue(out, rc);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final byte[] data = out.toByteArray();
	    return new String(data);
		/*
		 * model.addAttribute("accounts",uls.getAccountsByUserName(request.getSession().
		 * getAttribute("userName").toString())); return "Accounts.jsp";
		 */
	  
  }
}
