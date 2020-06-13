package com.mazebank.mazebank.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private long customerId;
	
	@Column(name = "customer_ssnid")
	private long customerSSN;
	
	@Column(name = "customer_status")
	private char customerStatus;
	
	@Column(name = "customer_lastupdate")
	private Date customerUpdate;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getCustomerSSN() {
		return customerSSN;
	}

	public void setCustomerSSN(long customerSSN) {
		this.customerSSN = customerSSN;
	}

	public char getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(char customerStatus) {
		this.customerStatus = customerStatus;
	}

	public Date getCustomerUpdate() {
		return customerUpdate;
	}

	public void setCustomerUpdate(Date customerUpdate) {
		this.customerUpdate = customerUpdate;
	}
	
	

}
