package com.kenneth.springbootecommerce.dto;

public class PurchaseResponse {

	private String orderTrackingNumber;
	
	public PurchaseResponse() {}
	
	public PurchaseResponse(String orderTrackingNumber) {
		super();
		this.orderTrackingNumber = orderTrackingNumber;
	}

	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}

	public void setOrderTrackingNumber(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}
	
}
