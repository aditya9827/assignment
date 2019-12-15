package com.example.model;

public enum CustomerType {
	EMPLOYEE(0.30), AFFILIATE(0.10), CUSTOMER(0);

	private double value;
	
	public double getValue() {
		return this.value;
	}
	private CustomerType(double value) {
		this.value = value;
	}

}
