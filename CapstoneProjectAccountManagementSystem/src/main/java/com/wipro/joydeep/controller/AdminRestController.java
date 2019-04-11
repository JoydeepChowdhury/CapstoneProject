package com.wipro.joydeep.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipro.joydeep.model.ResponseClass;
import com.wipro.joydeep.service.AccountService;
import com.wipro.joydeep.service.CustomerService;
import com.wipro.joydeep.service.UserDAOService;

@RestController
public class AdminRestController {

	@Autowired
	private CustomerService cs;
	
	@Autowired
	private UserDAOService udaos;
	
	@Autowired
	private AccountService asi;
	
	
	 @RequestMapping(value="/delete-customer",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	 public String deleteCustomer(@RequestParam String customerId)
	 {
		 boolean status=udaos.deleteUserByCustomerId(customerId);
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
	 }
	 
	 
	 @RequestMapping(value="/delete-account-for-a-customer",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	 public String deleteAccountForACustomer(@RequestParam String accountId,HttpServletRequest request)
	 {
		 String customerId=request.getSession().getAttribute("customerId").toString();
		 boolean status=asi.deleteAccountFromACustomer(accountId, customerId);
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
	 }
	 
	 
	 @RequestMapping(value="/set-customerid-in-session",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	 public String setCustomerIdInSession(@RequestParam String customerId,HttpServletRequest request)
	 {
		 
		 request.getSession().setAttribute("customerId",customerId);
		 
		 ResponseClass rc=new ResponseClass("success");
		
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
	 }
	 
	 @RequestMapping(value="/set-accountid-in-session",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	 public String setAccountIdInSession(@RequestParam String accountId,HttpServletRequest request)
	 {
		
		 request.getSession().setAttribute("accountId",accountId);
		 
		 ResponseClass rc=new ResponseClass("success");
		
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
	 }
	 
	 @RequestMapping(value="/set-filter-criteria",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	 public String setFilterCriteriaInSession(@RequestParam String filterfromdate,@RequestParam String filtertodate,HttpServletRequest request)
	 {
		 request.getSession().setAttribute("filterfromdate",filterfromdate);
		 request.getSession().setAttribute("filtertodate",filtertodate);
		 ResponseClass rc=new ResponseClass("success");
			
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
	 }
}
