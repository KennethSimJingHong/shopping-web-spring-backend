package com.kenneth.springbootecommerce.service;

import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenneth.springbootecommerce.dao.CustomerRepository;
import com.kenneth.springbootecommerce.dto.Purchase;
import com.kenneth.springbootecommerce.dto.PurchaseResponse;
import com.kenneth.springbootecommerce.entity.Customer;
import com.kenneth.springbootecommerce.entity.Order;
import com.kenneth.springbootecommerce.entity.OrderItem;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
//		retrieve the order info from dto
		Order order = purchase.getOrder();
		
//		generate tracking number
		String orderTrackingNumber = generateTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumber);
		
//		populate order with orderItems
		Set<OrderItem> orderItems = purchase.getOrderItems();
		orderItems.forEach(item -> order.add(item));
		
//		populate order with billingAddress and shippingAddress
		order.setBillingAddress(purchase.getBillingAddress());
		order.setBillingAddress(purchase.getShippingAddress());
		
//		populate customer with order
		Customer customer = purchase.getCustomer();
		customer.add(order);
		
//		save to the database
		customerRepository.save(customer);
		
//		return a response
		return new PurchaseResponse(orderTrackingNumber);
	}


	private String generateTrackingNumber() {
//		generate a random UUID number
		return UUID.randomUUID().toString();
	}

}
