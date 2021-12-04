package com.kenneth.springbootecommerce.service;

import com.kenneth.springbootecommerce.dto.Purchase;
import com.kenneth.springbootecommerce.dto.PurchaseResponse;

public interface CheckoutService {

	PurchaseResponse placeOrder(Purchase purchase);
}
