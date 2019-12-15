package com.example.discount;

import java.time.LocalDate;

import com.example.constants.DiscountConstants;
import com.example.model.Bill;
import com.example.model.CustomerType;

public class CalculateBillingDiscount implements ICalculateDiscount {
	private double percentageBasedDiscount;
	private double amountBasedDiscount;
	private double totalPayableAmount;

	public double calculateDiscount(Bill bill) {
		if (null != bill) {
			if (null != bill.getUserDetails()) {
				percentageBasedDiscount = percentageBasedDiscount(bill);

				amountBasedDiscount = amountBasedDiscount(bill);

				totalPayableAmount = bill.getBillAmount() - (percentageBasedDiscount + amountBasedDiscount);

			}
		}
		return totalPayableAmount;
	}

	private double amountBasedDiscount(Bill bill) {
		if (bill.getBillAmount() >= DiscountConstants.amountDiscountCutoff) {
			amountBasedDiscount = (bill.getBillAmount() / DiscountConstants.amountDiscountCutoff)
					* DiscountConstants.amountDiscount;
		}
		System.out.println("Amount Based Discount : " + amountBasedDiscount);
		return amountBasedDiscount;
	}

	private double percentageBasedDiscount(Bill bill) {
		if (bill.getUserDetails().getUserType().equals(CustomerType.EMPLOYEE)) {
			percentageBasedDiscount = CustomerType.EMPLOYEE.getValue() * bill.getBillAmount();
		} else if (bill.getUserDetails().getUserType().equals(CustomerType.AFFILIATE)) {
			percentageBasedDiscount = CustomerType.AFFILIATE.getValue() * bill.getBillAmount();
		} else if (LocalDate.now().getYear() - bill.getUserDetails().getDateOfJoining().getYear() >= 2) {
			percentageBasedDiscount = DiscountConstants.royalCustomerDiscount * bill.getBillAmount();
		}
		
		System.out.println("Percentage Based Discount : " + percentageBasedDiscount);
		return percentageBasedDiscount;
	}

	public double getDiscountAmount() {
		return percentageBasedDiscount;
	}

	public double getTotalPayableAmount() {
		return totalPayableAmount;
	}

	public void setTotalPayableAmount(double totalPayableAmount) {
		this.totalPayableAmount = totalPayableAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.percentageBasedDiscount = discountAmount;
	}

	public double getPercentageBasedDiscount() {
		return percentageBasedDiscount;
	}

	public void setPercentageBasedDiscount(double percentageBasedDiscount) {
		this.percentageBasedDiscount = percentageBasedDiscount;
	}

	public double getAmountBasedDiscount() {
		return amountBasedDiscount;
	}

	public void setAmountBasedDiscount(double amountBasedDiscount) {
		this.amountBasedDiscount = amountBasedDiscount;
	}

}
