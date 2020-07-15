package com.cdk.shoppingcart;

import com.cdk.shoppingcart.model.BillDetails;
import com.cdk.shoppingcart.model.Customer;
import com.cdk.shoppingcart.model.CustomerType;
import com.cdk.shoppingcart.service.DiscountProcessorBasedOnCustomerType;
import com.cdk.shoppingcart.service.IDiscountProcessorService;

public class Launcher {

	public static void main(String[] args) {
		
	 testRegularCustomer();
	 //System.out.println("--------------------------------------");
	 testPremiumCustomer();


 	
	}

	private static void testPremiumCustomer() {
		
		IDiscountProcessorService discountProcessor=new DiscountProcessorBasedOnCustomerType();
		Customer customer=new Customer(1,"ABC",CustomerType.PREMIUM);
		BillDetails billDetails=new BillDetails(4000);
		System.out.println(discountProcessor.applyDiscount(billDetails.getAmount(), customer));
		
		BillDetails billDetails2=new BillDetails(8000);
		System.out.println(discountProcessor.applyDiscount(billDetails2.getAmount(), customer));
		
		BillDetails billDetails3=new BillDetails(12000);
		System.out.println(discountProcessor.applyDiscount(billDetails3.getAmount(), customer));
		
		BillDetails billDetails4=new BillDetails(20000);
		System.out.println(discountProcessor.applyDiscount(billDetails4.getAmount(), customer));
		
	}

	private static void testRegularCustomer() {

		IDiscountProcessorService discountProcessor=new DiscountProcessorBasedOnCustomerType();
		Customer customer=new Customer(1,"ABC",CustomerType.REGULAR);
		BillDetails billDetails=new BillDetails(5000);
		System.out.println(discountProcessor.applyDiscount(billDetails.getAmount(), customer));
		
		BillDetails billDetails2=new BillDetails(10000);
		System.out.println(discountProcessor.applyDiscount(billDetails2.getAmount(), customer));
		
		BillDetails billDetails3=new BillDetails(15000);
		System.out.println(discountProcessor.applyDiscount(billDetails3.getAmount(), customer));
	
	}

}
