package com.wipro.joydeep.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wipro.joydeep.model.TransferDetails;
import com.wipro.joydeep.model.UserDetails;
import com.wipro.joydeep.service.TransferService;

@Controller
public class TransferController 
       {
           @Autowired
	        private TransferService ts;
	        
	        @RequestMapping(value="/get-transfer-bank-details",method=RequestMethod.GET)
	        private String getTransfers(Model model,HttpServletRequest request)
	        {
	        	if(request.getSession().getAttribute("userName")==null)
	   		 {
	   			 model.addAttribute("userdetails",new UserDetails());
	   			 return "Login";  
	   		 }
	        	else
	        	{
	        		String userName=request.getSession().getAttribute("userName").toString();	        	
		        	model.addAttribute("transactions",ts.getTransferDetails(userName));
		        	return "TransferDetails";
	        	}
	        	
	        }
	        
	        @RequestMapping(value="/get-transfer-bank-details-after-filtration",method=RequestMethod.GET)
	        private String getTransfersAfterFilter(Model model,HttpServletRequest request)
	        {
	        	if(request.getSession().getAttribute("userName")==null||request.getSession().getAttribute("filterfromdate")==null||request.getSession().getAttribute("filtertodate")==null)
	   		 {
	   			 model.addAttribute("userdetails",new UserDetails());
	   			 return "Login";  
	   		 }
	        	else
	        	{
	        		String userName=request.getSession().getAttribute("userName").toString();	    
	        		String fromDate=request.getSession().getAttribute("filterfromdate").toString();	
	        		String toDate=request.getSession().getAttribute("filtertodate").toString();
		        	model.addAttribute("transactions",ts.getTransferDetailsByDate(userName,fromDate,toDate));
		        	return "TransferDetails";
	        	}
	        	
	        }
	
       }
