package com.cdk.shoppingcart.test;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.cdk.shoppingcart.model.Customer;
import com.cdk.shoppingcart.model.CustomerType;
import com.cdk.shoppingcart.service.DiscountProcessorBasedOnCustomerType;
import com.cdk.shoppingcart.service.IDiscountProcessorService;
 
public class TestDiscountProcessorBasedOnCustomerType {
	IDiscountProcessorService discountProcessor;

	@Before
	public void setup(){
		discountProcessor=new DiscountProcessorBasedOnCustomerType();
	}

	@Test
	public void TestDiscountServiceForRegularCustomer(){

		Customer customerRegular=new Customer(1,"Customer1",CustomerType.REGULAR);
		double[] billAmounts={5000,10000,15000};
		double billAmount=0;

		String errorMsg="Calculated discount value is incorrect for bill amount : ";

		billAmount=billAmounts[0];
		double discountedAmount=discountProcessor.applyDiscount(billAmount, customerRegular);
		assertTrue(errorMsg+billAmount,discountedAmount==5000);


		billAmount=billAmounts[1];
		discountedAmount=discountProcessor.applyDiscount(billAmount, customerRegular);
		assertTrue(errorMsg+billAmount,discountedAmount==9500);

		billAmount=billAmounts[2];
		discountedAmount=discountProcessor.applyDiscount(billAmount, customerRegular);
		assertTrue(errorMsg+billAmount,discountedAmount==13500);

	}


	@Test
	public void TestDiscountServiceForPremiumCustomer(){

		Customer customerPremium=new Customer(2,"Customer2",CustomerType.PREMIUM);
		double[] billAmounts={4000,8000,12000,20000};
		double billAmount=0;

		String errorMsg="Discount value calculated incorrectly for ";

		billAmount=billAmounts[0];
		double discountedAmount=discountProcessor.applyDiscount(billAmount, customerPremium);
		assertTrue(errorMsg+billAmount,discountedAmount==3600);


		billAmount=billAmounts[1];
		discountedAmount=discountProcessor.applyDiscount(billAmount, customerPremium);
		assertTrue(errorMsg+billAmount,discountedAmount==7000);

		billAmount=billAmounts[2];
		discountedAmount=discountProcessor.applyDiscount(billAmount, customerPremium);
		assertTrue(errorMsg+billAmount,discountedAmount==10200);

		billAmount=billAmounts[3];
		discountedAmount=discountProcessor.applyDiscount(billAmount, customerPremium);
		assertTrue(errorMsg+billAmount,discountedAmount==15800);

	}
}



