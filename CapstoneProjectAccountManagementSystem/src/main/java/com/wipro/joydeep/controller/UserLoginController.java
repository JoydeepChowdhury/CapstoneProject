package com.wipro.joydeep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.wipro.joydeep.model.UserDetails;
import com.wipro.joydeep.service.UserLoginService;

@Controller
public class UserLoginController 
       {
    @Autowired       
	UserLoginService uls;
	
    private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);
    
	 @RequestMapping(value="/customer-home",method=RequestMethod.GET)
	 public String goToHome(ModelMap model,HttpServletRequest request)
	 {
		 if(request.getSession().getAttribute("userName")==null)
		 {
			 model.addAttribute("userdetails",new UserDetails());
			 return "Login";  
		 }
		 else
		 {
		 model.addAttribute("customer",uls.getCustomerDetailsByUsername(request.getSession().getAttribute("userName").toString()));
		 return "Home";
		 }
	 }
    
	 
	 @RequestMapping(value="/get-accounts-for-customer",method=RequestMethod.GET)
	 public String goToAccounts(ModelMap model, HttpServletRequest request)
	 {
		/*
		 * HttpSession session = request.getSession(false); if(session != null &&
		 * !session.isNew())
		 */
		 if(request.getSession().getAttribute("userName")==null)
		 {
			 model.addAttribute("userdetails",new UserDetails());
			 return "Login";  
		 }
		 else
		 {
		 model.addAttribute("accounts",uls.getAccountsByUserName(request.getSession().getAttribute("userName").toString()));
		 return "Accounts";
		 }
	 }
	 
	/*
	 * @ExceptionHandler(InvalidUserLoginException.class) public ModelAndView
	 * handleAllException(Exception ex) { ModelAndView model = new
	 * ModelAndView("Login"); model.addObject("error",
	 * InvalidUserLoginException.exceptionMessage);
	 * 
	 * return model;
	 * 
	 * }
	 */
	 
	 @RequestMapping(value="/login-customer",method=RequestMethod.POST)
	 public	 String login(@Valid @ModelAttribute("userdetails")UserDetails userdetails,BindingResult result,HttpServletRequest request,ModelMap model)
	 {
	 System.out.println(userdetails); 
	 if(result.hasErrors()) 
	 { 
		 return "error"; 
		 }
	 boolean status=uls.checkLoginCredentials(userdetails);
	 if(status==false)
	 {
		// LOGGER.error(InvalidUserLoginException.exceptionMessage+" Credentials entered is userName: "+userdetails.getUserName()+" and password: "+userdetails.getPassword());
			
			  model.addAttribute("error","Invalid Credentials");
			  return "Login";
			 
		 //throw new InvalidUserLoginException();
	 }
	 else
	 {
		 request.getSession().setAttribute("userName",userdetails.getUserName());
		 model.addAttribute("customer",uls.getCustomerDetails(userdetails));
		 return "Home";
	 }
	
	 }
	 
	@RequestMapping(value="/logout-user",method=RequestMethod.GET)
	public String logout(HttpServletRequest request,ModelMap model)
	{
		request.getSession().invalidate();
		model.addAttribute("userdetails",new UserDetails());
		return "Login";
	}
       }
