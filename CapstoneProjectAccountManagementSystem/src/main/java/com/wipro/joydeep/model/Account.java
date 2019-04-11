package com.wipro.joydeep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ACCOUNT_ENTITY")
public class Account 
{
	@Id
	@GenericGenerator(name="account_gen_id",strategy="com.wipro.joydeep.utilities.AccountIdGenerator")
	@GeneratedValue(generator="account_gen_id")
	@Column(name="ACCT_NO")
	private String accountNo;
	@Size(min=5, message = "Enter atleast 5 Characters.")
	@Column(name="ACCT_TYPE",nullable=false,length=50)
	private String accountType;
	@Column(name="ACCT_BALANCE",nullable=false,length=50)
	private double balance;
	@Size(min=3, message = "Enter atleast 3 Characters.")
	@Column(name="BANK_NAME",nullable=false,length=50)
	private String bankName;
	@Size(min=10, message = "Enter atleast 10 Characters.")
	@Column(name="BRANCH_DETAILS",nullable=false,length=100)
	private String branchDetails;
	@Column(name="DATE_OF_BO",nullable=false,length=50)
	private String dateOfBranchOpening;
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	
	
	public String getBranchDetails() {
		return branchDetails;
	}
	public void setBranchDetails(String branchDetails) {
		this.branchDetails = branchDetails;
	}
	public String getDateOfBranchOpening() {
		return dateOfBranchOpening;
	}
	public void setDateOfBranchOpening(String dateOfBranchOpening) {
		this.dateOfBranchOpening = dateOfBranchOpening;
	}
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountType=" + accountType + ", balance=" + balance
				+ ", bankName=" + bankName + ", branchDetails=" + branchDetails + ", dateOfBranchOpening="
				+ dateOfBranchOpening + "]";
	}
	
	
	

	

}
