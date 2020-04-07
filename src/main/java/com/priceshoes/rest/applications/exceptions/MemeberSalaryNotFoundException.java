package com.priceshoes.rest.applications.exceptions;

import com.priceshoes.rest.applications.exceptions.PriceshoesException;

public class MemeberSalaryNotFoundException extends PriceshoesException {
	private static final long serialVersionUID = 7660279297601140276L;

	public MemeberSalaryNotFoundException() {
	}

	public MemeberSalaryNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public MemeberSalaryNotFoundException(String message) {
		super(message);
	}

	public MemeberSalaryNotFoundException(Throwable cause) {
		super(cause);
	}
}