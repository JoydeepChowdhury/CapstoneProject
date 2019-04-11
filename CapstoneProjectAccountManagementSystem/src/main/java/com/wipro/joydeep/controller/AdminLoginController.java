package com.wipro.joydeep.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wipro.joydeep.model.Account;
import com.wipro.joydeep.model.Customer;
import com.wipro.joydeep.model.UserDetails;
import com.wipro.joydeep.service.AccountService;
import com.wipro.joydeep.service.CustomerService;
import com.wipro.joydeep.service.UserDAOService;
import com.wipro.joydeep.utilities.UniqueUserId;


@Controller
public class AdminLoginController {

	@Autowired
	private CustomerService cs;
	
	@Autowired
	private AccountService as;
	
	@Autowired
	private UniqueUserId uui;
	
	@Autowired
	private UserDAOService udserv;

	
	
	 @RequestMapping(value="/login-admin",method=RequestMethod.GET) public String login2(ModelMap model,HttpServletRequest request) 
	 {
		 if(request.getSession().getAttribute("AdminUser")!=null)
		   {
			 List<Customer> customerList=cs.getCustomersList();
			 model.addAttribute("customerList",customerList); 
			 return "CustomerDetails"; 
		   }
		 else
		 {
			 model.addAttribute("userdetails",new UserDetails());
		       return "AdminLogin";
		 }
	 }
	 
	
	 @RequestMapping(value="/login-admin",method=RequestMethod.POST)
	 public	 String login(@Valid @ModelAttribute("userdetails")UserDetails userdetails,BindingResult result,HttpServletRequest request,ModelMap model) 
	{
		 
    request.getSession().setAttribute("AdminUser",userdetails.getUserName());
	 if(result.hasErrors()) 
	 { 
		 return "error"; 
		 }
	 boolean status=userdetails.getUserName().equals("ADMIN")&&userdetails.getPassword().equals("password@47");
	 System.out.println(status);
	 if(status==false)
	 {
		 model.addAttribute("error","Invalid Credentials");
		 return "AdminLogin"; 
	 }
	 else
	 {
	     List<Customer> customerList=cs.getCustomersList();
	     model.addAttribute("customerList",customerList);
		 return "CustomerDetails";
	 }
	
	 }
	
	 @RequestMapping(value="/refresh-customer-list-after-customer-delete",method=RequestMethod.GET)
	 public String getCustomerListAfterCustomerDelete(ModelMap model)
	 {
		 
		 List<Customer> customerList=cs.getCustomersList();
	     model.addAttribute("customerList",customerList);
		 return "CustomerDetails";
	 }
	 
	 
	 
	 @RequestMapping(value="/customer-details-page",method=RequestMethod.GET)
	 public String goToCustomerDetails(ModelMap model,HttpServletRequest request)
	 {
		 if(request.getSession().getAttribute("AdminUser")!=null)
		 {
		 List<Customer> customerList=cs.getCustomersList();
	     model.addAttribute("customerList",customerList);
		 return "CustomerDetails";
		 }
		 else
		 {
			 model.addAttribute("userdetails",new UserDetails());
		       return "AdminLogin";
		 }
	 }
	 
	 
	/*
	 * @RequestMapping(value="/view-accounts-for-a-customer/{customerId}",method=
	 * RequestMethod.GET) public String viewAccountsOfACustomer(@PathVariable String
	 * customerId,ModelMap model,HttpServletRequest request) {
	 * request.getSession().setAttribute("customerId",customerId); List<Account>
	 * accounts=as.showAccountsOfACustomer(customerId); Customer
	 * customer=cs.getDetailsByCustomerId(customerId);
	 * model.addAttribute("accounts",accounts);
	 * model.addAttribute("customer",customer); return "CustomerAccountDetails"; }
	 */
	 
	 @RequestMapping(value="/view-accounts-for-a-customer",method=RequestMethod.GET)
	 public String viewAccountsOfACustomer(ModelMap model,HttpServletRequest request) 
	 {
		 if(request.getSession().getAttribute("AdminUser")!=null&&request.getSession().getAttribute("customerId")!=null)
		 {
		 String customerId=request.getSession().getAttribute("customerId").toString();
		 List<Account> accounts=as.showAccountsOfACustomer(customerId); 
		 Customer customer=cs.getDetailsByCustomerId(customerId);
		  model.addAttribute("accounts",accounts);
		  model.addAttribute("customer",customer); 
		  return "CustomerAccountDetails";
		 }
		 else
		 {
			 model.addAttribute("userdetails",new UserDetails());
		       return "AdminLogin";
		 }
	 }
	 @RequestMapping(value="/get-add-accounts-page",method=RequestMethod.GET)
	 public String getAddAccountsPage(ModelMap model,HttpServletRequest request)
	 {
		 if(request.getSession().getAttribute("AdminUser")!=null&&request.getSession().getAttribute("customerId")!=null)
		 {
			 String customerId=request.getSession().getAttribute("customerId").toString();
			 Customer customer=cs.getDetailsByCustomerId(customerId);
			 List<String> accountTypes=new ArrayList<String>();
			 List<String> bankNames=new ArrayList<String>();
			 accountTypes.add("Savings");
			 accountTypes.add("Current");
			 accountTypes.add("Reimbursement");
			 bankNames.add("SBI");
			 bankNames.add("UBI");
			 bankNames.add("UCO");
			 bankNames.add("IOB");
			 bankNames.add("HDFC");
			 bankNames.add("PNB");
			 bankNames.add("ICICI");
			 bankNames.add("CANARA");
			 model.addAttribute("customer",customer);
			 model.addAttribute("account",new Account());
			 model.addAttribute("accountTypes",accountTypes);
			 model.addAttribute("bankNames",bankNames);
			 return "AddAccount";
		 }
		 else
		 {
			 model.addAttribute("userdetails",new UserDetails());
		       return "AdminLogin";
		 }
		 
	 }
	
	 @RequestMapping(value="/get-update-account-page",method=RequestMethod.GET)
	 public String getUpdateAccountPage(ModelMap model,HttpServletRequest request)
	 {
		 if(request.getSession().getAttribute("AdminUser")!=null&&request.getSession().getAttribute("customerId")!=null&&request.getSession().getAttribute("accountId")!=null)
		 {
			 String customerId=request.getSession().getAttribute("customerId").toString();
			 Customer customer=cs.getDetailsByCustomerId(customerId);
			 List<String> accountTypes=new ArrayList<String>();
			 List<String> bankNames=new ArrayList<String>();
			 String accountId=request.getSession().getAttribute("accountId").toString();
			 Account desaccount=as.getAccountByAccountId(accountId);
			 accountTypes.add("Savings");
			 accountTypes.add("Current");
			 accountTypes.add("Reimbursement");
			 bankNames.add("SBI");
			 bankNames.add("UBI");
			 bankNames.add("UCO");
			 bankNames.add("IOB");
			 bankNames.add("HDFC");
			 bankNames.add("PNB");
			 bankNames.add("ICICI");
			 bankNames.add("CANARA");
			 model.addAttribute("customer",customer);
			 model.addAttribute("account",desaccount);
			 model.addAttribute("accountTypes",accountTypes);
			 model.addAttribute("bankNames",bankNames);
			 return "UpdateAccount";
		 }
		 else
		 {
			 model.addAttribute("userdetails",new UserDetails());
		       return "AdminLogin";
		 }
	 }
	 
	 @RequestMapping(value="/get-accounts-for-a-customer",method=RequestMethod.GET)
	 public String getAccountsForACustomer(ModelMap model,HttpServletRequest request)
	 {
		 String customerId=request.getSession().getAttribute("customerId").toString();
		 List<Account> accounts=as.showAccountsOfACustomer(customerId);
		 model.addAttribute("accounts",accounts);
		 model.addAttribute("customerId",customerId);
		 return "CustomerAccountDetails";
	 }
    
	 @RequestMapping(value="/get-add-customer-page",method=RequestMethod.GET)
	 public String goToCustomerLoginPage(ModelMap model,HttpServletRequest request)
	 {
		 if(request.getSession().getAttribute("AdminUser")!=null)
		 {
			 model.addAttribute("customer",new Customer());
			 return "AddCustomerPage";
		 }
		 else
		 {
			 model.addAttribute("userdetails",new UserDetails());
		       return "AdminLogin";
		 }
		 
	 }
	 
	 @RequestMapping(value="/add-new-customer",method=RequestMethod.GET)
	 public String addCustomer2(ModelMap model,HttpServletRequest request)
	 {
		 if(request.getSession().getAttribute("customerId")!=null&&request.getSession().getAttribute("AdminUser")!=null)
		 {
			 List<Customer> customerList=cs.getCustomersList();
	   	     model.addAttribute("customerList",customerList);
	   		 return "CustomerDetails";
		 }
		 else
		 {
			 model.addAttribute("userdetails",new UserDetails());
		       return "AdminLogin";
		 }
	 }
	 
	    @RequestMapping(value="/add-new-customer",method=RequestMethod.POST)
        public String addCustomer(@Valid @ModelAttribute("customer")Customer customer,BindingResult result,ModelMap model)
        {
        	if(result.hasErrors())
        	{
        		return "AddCustomerPage";
        	}
        	
        	UserDetails uds=new UserDetails();
        	String customerName=customer.getCustomerName();
        	String userId=customerName.substring(0,1).toUpperCase()+customerName.substring(1,2).toUpperCase()+UniqueUserId.get();
        	uds.setUserName(userId);
        	uds.setCustomer(customer);
        	udserv.createUser(uds);
        	List<Customer> customerList=cs.getCustomersList();
   	     model.addAttribute("customerList",customerList);
   		 return "CustomerDetails";
        }
	    
	    @RequestMapping(value="update-customer",method=RequestMethod.GET)
	    public String getCustomerAfterUpdate(HttpServletRequest request,ModelMap model)
	    {
	    	if(request.getSession().getAttribute("customerId")!=null&&request.getSession().getAttribute("AdminUser")!=null)
	    	{
	    		List<Customer> customerList=cs.getCustomersList();
	      	     model.addAttribute("customerList",customerList);
	      		 return "CustomerDetails";
	    	}
	    	else
	    	{
	    		 model.addAttribute("userdetails",new UserDetails());
			       return "AdminLogin";
	    	}
	    }
	    
	    @RequestMapping(value="update-customer",method=RequestMethod.POST)
	    public String updateCustomer(@Valid @ModelAttribute("customer")Customer customer,BindingResult result,ModelMap model,HttpServletRequest request)
	    {
	    	if(request.getSession().getAttribute("customerId")!=null&&request.getSession().getAttribute("AdminUser")!=null)
	    	{
	    		if(result.hasErrors())
	        	{
	        		return "AddCustomerPage";
	        	}
		    	boolean status=cs.updateCustomer(customer);
		    	if(status==true)
		    	{
		    		List<Customer> customerList=cs.getCustomersList();
		      	     model.addAttribute("customerList",customerList);
		      		 return "CustomerDetails";
		    	}
		    	else
		    	{
		    		 model.addAttribute("customer",customer);
					 return "AddCustomerPage";
		    	}
	    	}
	    	else
	    	{
	    		 model.addAttribute("userdetails",new UserDetails());
			       return "AdminLogin";
	    	}
	    		
	    }
	    
	    
	    @RequestMapping(value="/update-account-for-a-customer",method=RequestMethod.POST)
	    public String updateAccountsForCurrentCustomer(@Valid @ModelAttribute("account")Account account,BindingResult result,ModelMap model,HttpServletRequest request)
	    {
	    	HttpSession session=request.getSession();
		    if(session.getAttribute("AdminUser")!=null&&session.getAttribute("customerId")!=null&&session.getAttribute("accountId")!=null)
		    {
		    	String customerId=request.getSession().getAttribute("customerId").toString();
		    	String accountId=request.getSession().getAttribute("accountId").toString();
		    	Account desaccount=as.getAccountByAccountId(accountId);
		    	if(result.hasErrors())
		    	{
		    		Customer customer=cs.getDetailsByCustomerId(customerId);
		    		 List<String> accountTypes=new ArrayList<String>();
		    		 List<String> bankNames=new ArrayList<String>();
		    		 accountTypes.add("Savings");
		    		 accountTypes.add("Current");
		    		 accountTypes.add("Reimbursement");
		    		 bankNames.add("SBI");
		    		 bankNames.add("UBI");
		    		 bankNames.add("UCO");
		    		 bankNames.add("IOB");
		    		 bankNames.add("HDFC");
		    		 bankNames.add("PNB");
		    		 bankNames.add("ICICI");
		    		 bankNames.add("CANARA");
		    		 model.addAttribute("customer",customer);
		    		 model.addAttribute("account",desaccount);
		    		 model.addAttribute("accountTypes",accountTypes);
		    		 model.addAttribute("bankNames",bankNames);
		    		return "UpdateAccount";
		    	}
		    	boolean status=as.updateAccount(account);
		    	if(status==true)
		    	{
		    		 List<Account> accounts=as.showAccountsOfACustomer(customerId); 
					 Customer customer=cs.getDetailsByCustomerId(customerId);
					  model.addAttribute("accounts",accounts);
					  model.addAttribute("customer",customer); 
			    	return "CustomerAccountDetails";
		    	}
		    	else
		    	{
		    		Customer customer=cs.getDetailsByCustomerId(customerId);
		    		 List<String> accountTypes=new ArrayList<String>();
		    		 List<String> bankNames=new ArrayList<String>();
		    		 accountTypes.add("Savings");
		    		 accountTypes.add("Current");
		    		 accountTypes.add("Reimbursement");
		    		 bankNames.add("SBI");
		    		 bankNames.add("UBI");
		    		 bankNames.add("UCO");
		    		 bankNames.add("IOB");
		    		 bankNames.add("HDFC");
		    		 bankNames.add("PNB");
		    		 bankNames.add("ICICI");
		    		 bankNames.add("CANARA");
		    		 model.addAttribute("customer",customer);
		    		 model.addAttribute("account",desaccount);
		    		 model.addAttribute("accountTypes",accountTypes);
		    		 model.addAttribute("bankNames",bankNames);
		    		return "UpdateAccount";
		    	}
		    }
		    else
		    {
		    	 model.addAttribute("userdetails",new UserDetails());
			       return "AdminLogin";
		    }
	    }
	    
	   
	    
	    
	    @RequestMapping(value="/add-new-account-to-current-customer",method=RequestMethod.POST)
	    public String addAccountToCurrentCustomer(@Valid @ModelAttribute("account")Account account,BindingResult result,ModelMap model,HttpServletRequest request)
	    {
	    	String customerId=request.getSession().getAttribute("customerId").toString();
	    	System.out.println(account);
	    	System.out.println("I am after");
	    	if(result.hasErrors())
	    	{
	    		 Customer customer=cs.getDetailsByCustomerId(customerId);
	    		 List<String> accountTypes=new ArrayList<String>();
	    		 List<String> bankNames=new ArrayList<String>();
	    		 accountTypes.add("Savings");
	    		 accountTypes.add("Current");
	    		 accountTypes.add("Reimbursement");
	    		 bankNames.add("SBI");
	    		 bankNames.add("UBI");
	    		 bankNames.add("UCO");
	    		 bankNames.add("IOB");
	    		 bankNames.add("HDFC");
	    		 bankNames.add("PNB");
	    		 bankNames.add("ICICI");
	    		 bankNames.add("CANARA");
	    		 model.addAttribute("customer",customer);
	    		 model.addAttribute("account",new Account());
	    		 model.addAttribute("accountTypes",accountTypes);
	    		 model.addAttribute("bankNames",bankNames);
	    		return "AddAccount";
	    	}

	    	as.assignAccountToACustomer(account,customerId);
	    	 List<Account> accounts=as.showAccountsOfACustomer(customerId); 
			 Customer customer=cs.getDetailsByCustomerId(customerId);
			  model.addAttribute("accounts",accounts);
			  model.addAttribute("customer",customer); 
	    	return "CustomerAccountDetails";
	    }
	    
	    @GetMapping({"/logout-admin"})
	    public String adminlogin(Model model,HttpServletRequest request)
	    {
	       request.getSession().invalidate();
	       model.addAttribute("userdetails",new UserDetails());
	       return "AdminLogin";
	    } 
	    
	    
	    @RequestMapping(value="/getCustomerUpdatePage",method=RequestMethod.GET)
	    public String getCustomerUpdatePage(ModelMap model,HttpServletRequest request)
	    {
	    	HttpSession session=request.getSession();
	    	if(session.getAttribute("customerId")!=null&&session.getAttribute("AdminUser")!=null)
	    	{
	    		String customerId=session.getAttribute("customerId").toString();
	    		Customer customer=cs.getDetailsByCustomerId(customerId);
	    		model.addAttribute("customer",customer);
	    		return "UpdateCustomer";
	    	}
	    	else
	    	{
	    		model.addAttribute("userdetails",new UserDetails());
			       return "AdminLogin";
	    	}
	    }
	    
	    
	    
	    
	 
}
