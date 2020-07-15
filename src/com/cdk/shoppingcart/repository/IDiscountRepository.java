package com.cdk.shoppingcart.repository;

import com.cdk.shoppingcart.model.CustomerType;
import com.cdk.shoppingcart.model.DiscountCategory;

public interface IDiscountRepository {

	DiscountCategory getDiscountCategoryForCustomerType(CustomerType customerType);

}