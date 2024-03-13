package com.mycartt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 10)
	private int userId;
	
	@Column(length = 100)
	private String userName;
	
	@Column(length = 100)
	private String userEmail;
	
	@Column(length = 100)
	private String userPassword;
	@Column(length = 12)
	private String userPhone;
	
	@Column(length = 1500)
	private String address;

	public User(String userName, String userEmail, String userPassword, String userPhone, String address) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.address = address;
	}

	
	public User() {
		
	}


	public int getUserId() {
		return userId;
	}


	public String getUserName() {
		return userName;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public String getUserPhone() {
		return userPhone;
	}


	public String getAddress() {
		return address;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", userPhone=" + userPhone + ", address=" + address + "]";
	}


	
	
	

}
