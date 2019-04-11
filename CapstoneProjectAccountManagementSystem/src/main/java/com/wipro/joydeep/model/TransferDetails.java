package com.wipro.joydeep.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRANSFER_ENTITY_TABLE")
public class TransferDetails {
    
	@Id
	@Column(name="TRANSFER_ID")
	@GeneratedValue
	private int transferId;
	@Column(name="SOURCE_AC_NO")
	private String sourceAccountNo;
	@Column(name="DEST_AC_NO")
	private String destinationAccountNo;
	@Column(name="AMOUNT")
	private double amount;
	@Column(name="TRANSACTION_DATE")
	private LocalDateTime transactionTime;
	@Column(name="USER_NAME")
	private String userName;
	public int getTransferId() {
		return transferId;
	}
	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}
	public String getSourceAccountNo() {
		return sourceAccountNo;
	}
	public void setSourceAccountNo(String sourceAccountNo) {
		this.sourceAccountNo = sourceAccountNo;
	}
	public String getDestinationAccountNo() {
		return destinationAccountNo;
	}
	public void setDestinationAccountNo(String destinationAccountNo) {
		this.destinationAccountNo = destinationAccountNo;
	}
	public LocalDateTime getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(LocalDateTime transactionTime) {
		this.transactionTime = transactionTime;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "TransferDetails [transferId=" + transferId + ", sourceAccountNo=" + sourceAccountNo
				+ ", destinationAccountNo=" + destinationAccountNo + ", amount=" + amount + ", transactionTime="
				+ transactionTime + ", userName=" + userName + ", getTransferId()=" + getTransferId()
				+ ", getSourceAccountNo()=" + getSourceAccountNo() + ", getDestinationAccountNo()="
				+ getDestinationAccountNo() + ", getTransactionTime()=" + getTransactionTime() + ", getAmount()="
				+ getAmount() + ", getUserName()=" + getUserName() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
}
