package com.mazebank.mazebank.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
@Table(name = "customerdetails")
public class CustomerDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "customerdetails_id")
	private long customerId;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="customer_age")
	private int customerAge;
	
	@Column(name="customer_city")
	private String customerCity;
	
	@Column(name="customer_address1")
	private String customerAddress1;
	
	@Column(name="customer_address2")
	private String customerAddress2;
	
	public long getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(long customerId) {
		this.customerId=customerId;
	}
	
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName=customerName;
	}
	
	
	public int getCustomerAge() {
		return customerAge;
	}
	
	public void setCustomerAge(int customerAge) {
		this.customerAge=customerAge;
	}
	
	
	public String getCustomerCity() {
		return customerCity;
	}
	
	public void setCustomerCity(String customerCity) {
		this.customerCity=customerCity;
	}
	
	
	public String getCustomerAddress1() {
		return customerAddress1;
	}
	
	public void setCustomerAddress1(String customerAddress1) {
		this.customerAddress1=customerAddress1;
	}
	
	public String getCustomerAddress2() {
		return customerAddress2;
	}
	
	public void setCustomerAddress2(String customerAddress2) {
		this.customerAddress2=customerAddress2;
	}
}
