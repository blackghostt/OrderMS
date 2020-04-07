package com.priceshoes.rest.applications.exceptions;

import com.priceshoes.rest.applications.exceptions.PriceshoesException;

public class BeanNotFoundException extends PriceshoesException {
	private static final long serialVersionUID = -1827734718641658503L;

	public BeanNotFoundException() {
	}

	public BeanNotFoundException(String message) {
		super(message);
	}

	public BeanNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public BeanNotFoundException(Throwable cause) {
		super(cause);
	}
}