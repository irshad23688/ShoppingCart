package com.cdk.shoppingcart.repository;

import static com.cdk.shoppingcart.utils.CartConstants.PREMIUM_DISCOUNT;
import static com.cdk.shoppingcart.utils.CartConstants.REGULAR_DISCOUNT;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.cdk.shoppingcart.model.DiscountCategory;
import com.cdk.shoppingcart.model.DiscountSlab;

public class DBStub {
	public static Map<String,DiscountCategory> discountCategories=new HashMap<>(); 
	public static void initDiscountCategory(){
	
		DiscountSlab[] ds={new DiscountSlab(0,5000,0),
							new DiscountSlab(5000,10000,10),
							new DiscountSlab(10000,Integer.MAX_VALUE,20)};
		
		DiscountCategory regularCategory=new DiscountCategory(1,REGULAR_DISCOUNT,Arrays.asList(ds));
		 discountCategories.put(REGULAR_DISCOUNT,regularCategory);
		DiscountSlab[] ds2={new DiscountSlab(0,4000,10),
							new DiscountSlab(4000,8000,15),
							new DiscountSlab(8000,12000,20),
							new DiscountSlab(12000,Integer.MAX_VALUE,30)};
		DiscountCategory premiumCategory=new DiscountCategory(2,PREMIUM_DISCOUNT,Arrays.asList(ds2));
		discountCategories.put(PREMIUM_DISCOUNT,premiumCategory);
	}
	
}
