package com.cdk.shoppingcart.model;

public class DiscountSlab {

	private int lowPrice;
	private int highPrice;
	private int percentageDiscount;

	public DiscountSlab(int lowPrice, int highPrice, int percentageDiscount) {
		this.lowPrice = lowPrice;
		this.highPrice = highPrice;
		this.percentageDiscount = percentageDiscount;
	}
	public int getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(int lowPrice) {
		this.lowPrice = lowPrice;
	}
	public int getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(int highPrice) {
		this.highPrice = highPrice;
	}
	public int getPercentageDiscount() {
		return percentageDiscount;
	}
	public void setPercentageDiscount(int percentageDiscount) {
		this.percentageDiscount = percentageDiscount;
	}



}
