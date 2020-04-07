package com.priceshoes.rest.applications.exceptions;

import com.priceshoes.rest.applications.exceptions.PriceshoesException;

public class CatalogInfoNotFoundException extends PriceshoesException {
	private static final long serialVersionUID = -6064711127798157959L;

	public CatalogInfoNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CatalogInfoNotFoundException(String message) {
		super(message);
	}

	public CatalogInfoNotFoundException(Throwable cause) {
		super(cause);
	}
}