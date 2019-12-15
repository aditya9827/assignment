package com.example.model;

import java.time.LocalDate;

public class Customer {

	private CustomerType userType;

	private LocalDate dateOfJoining;

	public Customer(CustomerType userType, LocalDate dateOfJoining) {
		this.userType = userType;
		this.dateOfJoining = dateOfJoining;
	}

	public CustomerType getUserType() {
		return userType;
	}

	public void setUserType(CustomerType userType) {
		this.userType = userType;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

}
