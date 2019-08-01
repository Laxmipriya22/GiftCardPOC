package com.springboot.svss.model;


public class PaymentSVSSInfo {
	private String Id;
	private String username;
	private String balance;
	private String phoneNumber;
	private String dateOfBirth;

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getId() {
		return Id;
	}

	public void setId(String Id) {
		this.Id = Id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PaymentSVSSInfo(String Id, String username, String balance, String phoneNumber, String dateOfBirth) {
		super();
		this.Id = Id;
		this.username = username;
		this.balance = balance;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
	}

	public PaymentSVSSInfo() {
		// TODO Auto-generated constructor stub
	}

}
