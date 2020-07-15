package com.cdk.shoppingcart.model;

import java.util.List;

public class DiscountCategory {
	private int id;
	private String categoryName;
	private List<DiscountSlab> discountSlabs;
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<DiscountSlab> getDiscountSlabs() {
		return discountSlabs;
	}
	public void setDiscountSlabs(List<DiscountSlab> discountSlabs) {
		this.discountSlabs = discountSlabs;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public DiscountCategory(int id,String categoryName, List<DiscountSlab> discountSlabs) {

		this.id=id;
		this.categoryName = categoryName;
		this.discountSlabs = discountSlabs;
	}


}
