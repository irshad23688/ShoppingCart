package com.cdk.shoppingcart.service;

import com.cdk.shoppingcart.model.Customer;

/**
 * @author irshad.shaikh
 *
 */
public interface IDiscountProcessorService {

	double applyDiscount(double cartValue, Customer customer);

}