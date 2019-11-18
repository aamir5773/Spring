package com.lti.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Accounts")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="acc_type")
public abstract class Account{
	@Id
	private long accountNumber;
	private String accountHolderName;
	private double accountBalance;
	
	@OneToMany(mappedBy="account", cascade=CascadeType.ALL)
	private Transaction transaction;
	
	public Account() {
	}

	public Account(long accountNumber, String accountHolderName, double accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName
				+ ", accountBalance=" + accountBalance + "]";
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}


}
