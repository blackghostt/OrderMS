package com.priceshoes.rest.applications.exceptions;

public class PriceshoesException extends Exception {
	private static final long serialVersionUID = -8744351495138821072L;

	public PriceshoesException() {
	}

	public PriceshoesException(String message, Throwable cause) {
		super(message, cause);
	}

	public PriceshoesException(String message) {
		super(message);
	}

	public PriceshoesException(Throwable cause) {
		super(cause);
	}
}