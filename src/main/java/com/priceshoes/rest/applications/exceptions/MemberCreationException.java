package com.priceshoes.rest.applications.exceptions;

import com.priceshoes.rest.applications.exceptions.PriceshoesException;

public class MemberCreationException extends PriceshoesException {
	private static final long serialVersionUID = -6064711127798157959L;

	public MemberCreationException() {
	}

	public MemberCreationException(String message, Throwable cause) {
		super(message, cause);
	}

	public MemberCreationException(String message) {
		super(message);
	}

	public MemberCreationException(Throwable cause) {
		super(cause);
	}
}