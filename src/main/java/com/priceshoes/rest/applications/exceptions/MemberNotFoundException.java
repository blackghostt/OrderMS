package com.priceshoes.rest.applications.exceptions;

import com.priceshoes.rest.applications.exceptions.PriceshoesException;

public class MemberNotFoundException extends PriceshoesException {
	private static final long serialVersionUID = -6064711127798157959L;

	public MemberNotFoundException() {
	}

	public MemberNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public MemberNotFoundException(String message) {
		super(message);
	}

	public MemberNotFoundException(Throwable cause) {
		super(cause);
	}
}