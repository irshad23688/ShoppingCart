package com.cdk.shoppingcart.service;

import static com.cdk.shoppingcart.utils.CartConstants.DOUBLE_ZERO;
import static com.cdk.shoppingcart.utils.CartConstants.INT_ZERO;

import java.util.function.BiFunction;

import com.cdk.shoppingcart.model.Customer;
import com.cdk.shoppingcart.model.DiscountCategory;
import com.cdk.shoppingcart.model.DiscountSlab;
import com.cdk.shoppingcart.repository.DiscountBasedOnCustomerTypeRepository;
import com.cdk.shoppingcart.repository.IDiscountRepository;

 
public class DiscountProcessorBasedOnCustomerType implements IDiscountProcessorService {
	private IDiscountRepository discountRepository;

	public DiscountProcessorBasedOnCustomerType(){
		discountRepository=new  DiscountBasedOnCustomerTypeRepository();
	}

	@Override
	public double applyDiscount(double cartValue,Customer customer){
		DiscountCategory discountCategory=discountRepository.getDiscountCategoryForCustomerType(customer.getCustomerType());
		return processDiscountForCurrentCategory(cartValue,discountCategory);
	}

	/**
	 * @param cartValue
	 * @param discountCategory
	 * @return cartValue which is discounted 
	 */
	private double processDiscountForCurrentCategory(double cartValue, DiscountCategory discountCategory){
		double totalDiscount=DOUBLE_ZERO;
		
		for(DiscountSlab discountSlab:discountCategory.getDiscountSlabs()){
			if(discountSlab.getPercentageDiscount()==INT_ZERO){
				continue;
			}	
			double discountForCurrentSlab=processDiscountForCurrentSlab(cartValue,discountSlab);
			if(discountForCurrentSlab!=DOUBLE_ZERO)
				totalDiscount+=discountForCurrentSlab;
			else
				break;
		}
		return cartValue-totalDiscount;
	}
	/**
	 * @param cartValue
	 * @param discountSlab
	 * @return discount amount on basis of lower & higher price 
	 */
	private double  processDiscountForCurrentSlab(double cartValue, DiscountSlab discountSlab) {
		BiFunction<Double,Integer,Double>  deductAmountLessThanLowerSlab = (d1,d2) -> d1-d2; 
		BiFunction<Double,Integer,Double>  deductAmountIfGreaterThanHigherSlab = (d1,d2) -> d1>d2?d1-d2:DOUBLE_ZERO;
		double amountForDiscountCalculation=deductAmountLessThanLowerSlab.apply(cartValue,discountSlab.getLowPrice());
		amountForDiscountCalculation-=deductAmountIfGreaterThanHigherSlab.apply(cartValue,discountSlab.getHighPrice());
		if(amountForDiscountCalculation<=DOUBLE_ZERO){
			return DOUBLE_ZERO;
		}
		else 
			return (amountForDiscountCalculation*discountSlab.getPercentageDiscount()/100);
	}

}
