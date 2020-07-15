package com.cdk.shoppingcart.repository;

import java.util.HashMap;
import java.util.Map;

import com.cdk.shoppingcart.model.CustomerType;
import com.cdk.shoppingcart.model.DiscountCategory;
import static com.cdk.shoppingcart.utils.CartConstants.*;

 
public class DiscountBasedOnCustomerTypeRepository implements IDiscountRepository {
	
	
	private Map<CustomerType,DiscountCategory> customerTypeDiscountAssociation=new HashMap<>();
	
	public DiscountBasedOnCustomerTypeRepository(){
		DBStub.initDiscountCategory();
		customerTypeDiscountAssociation.put(CustomerType.REGULAR, DBStub.discountCategories.get(REGULAR_DISCOUNT));
		customerTypeDiscountAssociation.put(CustomerType.PREMIUM, DBStub.discountCategories.get(PREMIUM_DISCOUNT));
	}
	

	@Override
	public DiscountCategory getDiscountCategoryForCustomerType(CustomerType customerType){
		return customerTypeDiscountAssociation.get(customerType);
	}

}
