package com.example.model;

public class Bill {

	private Customer userDetails;

	private double billAmount;

	public Bill(Customer userDetails, double billAmount) {
		this.userDetails = userDetails;
		this.billAmount = billAmount;
	}

	public Customer getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(Customer userDetails) {
		this.userDetails = userDetails;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

}
