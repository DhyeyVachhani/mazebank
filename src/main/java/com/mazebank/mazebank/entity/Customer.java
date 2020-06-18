package com.mazebank.mazebank.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_master")
@SequenceGenerator(name = "cust_seq" , initialValue = 100000000, allocationSize = 1)
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "cust_seq")
	@Column(name = "customer_id")
	private long customerId;
	
	@Column(name = "customer_ssnid")
	private long customerSSN;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "customer_addressline1")
	private String customerAddressLine1;

	@Column(name = "customer_addressline2")
	private String customerAddressLine2;

	@Column(name = "customer_age")
	private int customerAge;

	@Column(name = "customer_status")
	private String customerStatus;
	
	@Column(name = "customer_lastupdate")
	private Date customerUpdate;

	@Column(name = "customer_state")
	private Date customerState;

	@Column(name = "customer_city")
	private Date customerCity;
}
