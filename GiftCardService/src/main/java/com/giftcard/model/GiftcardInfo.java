package com.giftcard.model;

import org.dozer.Mapping;


public class GiftcardInfo {

	@Mapping("Id")
	private String giftId;
	@Mapping
	private double balance;
	@Mapping
	private String dateOfBirth;

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getGiftId() {
		return giftId;
	}

	public void setGiftId(String giftId) {
		this.giftId = giftId;
	}

}