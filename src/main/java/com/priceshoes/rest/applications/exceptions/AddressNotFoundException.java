package com.priceshoes.rest.applications.exceptions;

import com.priceshoes.rest.applications.exceptions.PriceshoesException;

public class AddressNotFoundException extends PriceshoesException {
	private static final long serialVersionUID = 3381772294232402020L;

	public AddressNotFoundException() {
	}

	public AddressNotFoundException(String message) {
		super(message);
	}

	public AddressNotFoundException(Throwable cause) {
		super(cause);
	}

	public AddressNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}