package com.cdk.shoppingcart.model;

public class BillDetails {
	private int orderId;
	private double amount;
	private double discountedAmount;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getDiscountedAmount() {
		return discountedAmount;
	}
	public void setDiscountedAmount(double discountedAmount) {
		this.discountedAmount = discountedAmount;
	}
	public BillDetails( double amount) {

		this.amount = amount;

	}
}
