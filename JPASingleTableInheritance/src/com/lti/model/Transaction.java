package com.lti.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;





@Entity
public class Transaction {
	@Id
	private int transactionId;
	private int transactionAmount;
	
	@ManyToOne
	@JoinColumn(name="acc_no")
	private Account account;
	
	public Transaction() {
	
	}

	public Transaction(int transactionId, int transactionAmount) {
		super();
		this.transactionId = transactionId;
		this.transactionAmount = transactionAmount;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionAmount=" + transactionAmount + "]";
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	

	
}
