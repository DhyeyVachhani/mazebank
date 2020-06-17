package com.mazebank.mazebank.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "account")
@SequenceGenerator(name = "account_seq" , initialValue = 500000000, allocationSize = 1)
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "account_seq")
	@Column(name = "account_id")
	private long accountId;
	
	@Column(name = "customer_id")
	private long customerId;
	
	@Column(name = "account_type")
	private String accountType;
	
	@Column(name = "account_status")
	private String accountStatus;
	
	@Column(name = "account_lastupdate")
	private Date accountUpdate;

	@Column(name="account_balance")
	private long balance;

	@Column(name = "account_creation_date")
	private Date crDate;
}