package com.mazebank.mazebank.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_master")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "userstore_id")
	private int userstoreId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_password")
	private String userPassword;
	
	@Column(name = "user_timestamp")
	private Date userTimestamp;
	
	@Column(name = "user_role")
	private char userRole;

	public int getUserstoreId() {
		return userstoreId;
	}

	public void setUserstoreId(int userstoreId) {
		this.userstoreId = userstoreId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Date getUserTimestamp() {
		return userTimestamp;
	}

	public void setUserTimestamp(Date userTimestamp) {
		this.userTimestamp = userTimestamp;
	}

	public char getUserRole() {
		return userRole;
	}

	public void setUserRole(char userRole) {
		this.userRole = userRole;
	}
	
	
}