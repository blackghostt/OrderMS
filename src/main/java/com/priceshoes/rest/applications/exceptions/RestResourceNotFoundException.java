package com.priceshoes.rest.applications.exceptions;

import com.priceshoes.rest.applications.exceptions.PriceshoesException;

public final class RestResourceNotFoundException extends PriceshoesException {
	private static final long serialVersionUID = -3925573739180537771L;

	public RestResourceNotFoundException() {
	}

	public RestResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public RestResourceNotFoundException(String message) {
		super(message);
	}

	public RestResourceNotFoundException(Throwable cause) {
		super(cause);
	}
}