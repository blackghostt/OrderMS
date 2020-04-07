package com.priceshoes.rest.applications.bean;

import java.io.Serializable;

public class ExceptionResponse implements Serializable {
	private static final long serialVersionUID = 4279868890137782256L;
	private int code;
	private String message;
	private String exception;

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getException() {
		return this.exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}
}