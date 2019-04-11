package com.wipro.joydeep.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="USER_ENTITY_TABLE")
public class UserDetails implements Serializable
        {
	       
	         @Id
	         @Column(name="USER_NAME",nullable=false,length=250)
             private String userName;
	         
	         @Id
	         @GenericGenerator(name="password_gen_id",strategy="com.wipro.joydeep.utilities.PasswordGenerator")
	     	 @GeneratedValue(generator="password_gen_id")
	         @Column(name="PWD",nullable=false,length=250)
             private String password;
	         @OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
             private Customer customer;
	       
	         
	         public UserDetails() 
	         {
                                     
	         }

			public UserDetails(String userName, String password, Customer customer) {
				super();
				this.userName = userName;
				this.password = password;
				this.customer = customer;
			}

			public String getUserName() {
				return userName;
			}

			public void setUserName(String userName) {
				this.userName = userName;
			}

			public String getPassword() {
				return password;
			}

			public void setPassword(String password) {
				this.password = password;
			}

			public Customer getCustomer() {
				return customer;
			}

			public void setCustomer(Customer customer) {
				this.customer = customer;
			}

			@Override
			public String toString() {
				return "UserDetails [userName=" + userName + ", password=" + password + ", customer=" + customer + "]";
			}
	         
        }    
