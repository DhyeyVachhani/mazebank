package com.mazebank.mazebank.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Setter
@Getter
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
}
