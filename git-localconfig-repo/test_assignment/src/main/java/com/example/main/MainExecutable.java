package com.example.main;

import java.time.LocalDate;

import com.example.discount.CalculateBillingDiscount;
import com.example.model.Bill;
import com.example.model.Customer;
import com.example.model.CustomerType;

public class MainExecutable {

	public static void main(String[] args) {
		Customer user1 = new Customer(CustomerType.CUSTOMER, LocalDate.of(2017, 10, 12));
		
		Bill billOfUser1 = new Bill(user1, 10);
		
		CalculateBillingDiscount discountAmount = new CalculateBillingDiscount();
		System.out.println("Payable Amount : " + discountAmount.calculateDiscount(billOfUser1));
	}

}
