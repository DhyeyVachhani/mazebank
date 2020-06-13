package com.mazebank.mazebank.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "account_id")
	private long accountId;
	
	@Column(name = "customer_id")
	private long customerId;
	
	@Column(name = "account_type")
	private char accountType;
	
	@Column(name = "account_status")
	private char accountStatus;
	
	@Column(name = "account_lastupdate")
	private Date accountUpdate;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public char getAccountType() {
		return accountType;
	}

	public void setAccountType(char accountType) {
		this.accountType = accountType;
	}

	public char getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(char accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Date getAccountUpdate() {
		return accountUpdate;
	}

	public void setAccountUpdate(Date accountUpdate) {
		this.accountUpdate = accountUpdate;
	}
	
	

}
