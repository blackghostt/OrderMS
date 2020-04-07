package com.priceshoes.rest.applications.exceptions;

import com.priceshoes.rest.applications.exceptions.PriceshoesException;

public class InventoryNotFoundException extends PriceshoesException {
	private static final long serialVersionUID = 7078173099006420356L;

	public InventoryNotFoundException() {
	}

	public InventoryNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public InventoryNotFoundException(String message) {
		super(message);
	}

	public InventoryNotFoundException(Throwable cause) {
		super(cause);
	}
}