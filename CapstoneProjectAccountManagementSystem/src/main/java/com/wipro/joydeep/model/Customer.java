package com.wipro.joydeep.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="CUSTOMER_ENTITY")
public class Customer 
       {
	         @Id
	         @GenericGenerator(name="customer_gen_id",strategy="com.wipro.joydeep.utilities.CustomerIdGenerator")
	         @GeneratedValue(generator="customer_gen_id")
	         @Column(name="CUSTOMER_ID")
             private String customerId;
	         @Size(min=5, message = "Enter atleast 5 Characters.")
	         @Column(name="CUSTOMER_NAME",nullable=false,length=100)
             private String customerName;
	         @Size(min=10, message = "Enter atleast 10 Characters.")
	         @Column(name="CUSTOMER_ADDRESS",nullable=false,length=200)
             private String customerAddress;
	         @Column(name="CUSTOMER_DOB",nullable=false,length=50)
             private String customerDateOfBirth;
	         
	        
	         @OneToMany(fetch=FetchType.LAZY,targetEntity=Account.class,cascade=CascadeType.ALL)
	         @JoinColumn(name="CUSTOMER_ID",referencedColumnName="CUSTOMER_ID")
             private List<Account> accounts;
		
	         
	         
	         public String getCustomerId() 
	            {
				return customerId;
			    }
			public void setCustomerId(String customerId) {
				this.customerId = customerId;
			}
			public String getCustomerName() {
				return customerName;
			}
			public void setCustomerName(String customerName) {
				this.customerName = customerName;
			}
			public String getCustomerAddress() {
				return customerAddress;
			}
			public void setCustomerAddress(String customerAddress) {
				this.customerAddress = customerAddress;
			}
			public String getCustomerDateOfBirth() {
				return customerDateOfBirth;
			}
			public void setCustomerDateOfBirth(String customerDateOfBirth) {
				this.customerDateOfBirth = customerDateOfBirth;
			}
			public List<Account> getAccounts() {
				System.out.println(accounts);
				return accounts;
			}
			public void setAccounts(List<Account> accounts) {
				
				this.accounts = accounts;
			}
			@Override
			public String toString() {
				return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
						+ customerAddress + ", customerDateOfBirth=" + customerDateOfBirth + ", accounts=" + accounts
						+ "]";
			}
             
             
             
             
       }
