package com.wipro.joydeep.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.joydeep.model.UserDetails;
import com.wipro.joydeep.service.NewAccountService;
import com.wipro.joydeep.service.UserLoginService;

@Controller
public class NewAccountController {
    @Autowired
	private NewAccountService nas;
    @Autowired       
   	UserLoginService uls;
	
	@RequestMapping(value="/get-account-details-by-id/{accountId}",method=RequestMethod.GET)
	public String getAccountDetailsById(@PathVariable String accountId,ModelMap map,HttpServletRequest request)
	{
		if(request.getSession().getAttribute("userName")==null)
		 {
			 map.addAttribute("userdetails",new UserDetails());
			 return "Login";  
		 }
		else
		{
		map.addAttribute("account",nas.getAccountDetailsById(accountId));
		return "AccountDetailsPage";
		}
	}
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String get()
	{
		return "AccountDetailsPage";
	}
	
	@RequestMapping(value="/transactions",method=RequestMethod.GET)
	public String goToDoTransaction(ModelMap model,HttpServletRequest request)
	{
		if(request.getSession().getAttribute("userName")==null)
		 {
			 model.addAttribute("userdetails",new UserDetails());
			 return "Login";  
		 }
		else
		{
		return "TransferFunds";
		}
	}
	
	@RequestMapping(value="/transfer-funds",method=RequestMethod.GET)
	public String transferfunds(@RequestParam String from_acc_no, @RequestParam String to_acc_no, @RequestParam String balance,ModelMap model,HttpServletRequest request)
	{
		nas.makeTransaction(from_acc_no,to_acc_no,Double.parseDouble(balance),request.getSession().getAttribute("userName").toString());
		model.addAttribute("accounts",uls.getAccountsByUserName(request.getSession().getAttribute("userName").toString()));
		 return "Accounts.jsp";
	}
	
	
}
