package com.priceshoes.rest.applications.exceptions;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.priceshoes.rest.applications.bean.ExceptionResponse;
import com.priceshoes.rest.applications.exceptions.AddressNotFoundException;
import com.priceshoes.rest.applications.exceptions.BeanNotFoundException;
import com.priceshoes.rest.applications.exceptions.InventoryNotFoundException;
import com.priceshoes.rest.applications.exceptions.MemberCreationException;
import com.priceshoes.rest.applications.exceptions.MemberNotFoundException;
import com.priceshoes.rest.applications.exceptions.MemeberSalaryNotFoundException;
import com.priceshoes.rest.applications.exceptions.PriceshoesException;
import com.priceshoes.rest.applications.exceptions.RestResourceNotFoundException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class PriceshoesGlobalExceptionHandler {
	private static Logger log = Logger.getLogger(PriceshoesGlobalExceptionHandler.class);

	@ExceptionHandler({ PriceshoesException.class })
	public ResponseEntity<ExceptionResponse> handlePriceshoesException(PriceshoesException exp) {
		ExceptionResponse expResp = new ExceptionResponse();
		expResp.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		expResp.setException("PriceshoesException");
		expResp.setMessage(exp.getMessage());
		return new ResponseEntity(expResp, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({ MemberCreationException.class })
	public ResponseEntity<ExceptionResponse> handleMemberCreationException(MemberCreationException exp) {
		ExceptionResponse expResp = new ExceptionResponse();
		expResp.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		expResp.setException("MemberCreationException");
		expResp.setMessage(exp.getMessage());
		return new ResponseEntity(expResp, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({ MemberNotFoundException.class })
	public ResponseEntity<ExceptionResponse> handleMemberNotFoundException(MemberNotFoundException exp) {
		ExceptionResponse expResp = new ExceptionResponse();
		expResp.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		expResp.setException("MemberNotFoundException");
		expResp.setMessage(exp.getMessage());
		return new ResponseEntity(expResp, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({ NullPointerException.class })
	public ResponseEntity<ExceptionResponse> handleNullPointerException(NullPointerException exp) {
		ExceptionResponse expResp = new ExceptionResponse();
		expResp.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		expResp.setException("NullPointerException");
		expResp.setMessage(exp.getMessage());
		return new ResponseEntity(expResp, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({ InventoryNotFoundException.class })
	public ResponseEntity<ExceptionResponse> handleInventoryNotFoundException(InventoryNotFoundException exp) {
		ExceptionResponse expResp = new ExceptionResponse();
		expResp.setCode(HttpStatus.NOT_FOUND.value());
		expResp.setException("InventoryNotFoundException");
		expResp.setMessage(exp.getMessage() + "\n" + exp.getCause());
		return new ResponseEntity(expResp, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ RestResourceNotFoundException.class })
	public ResponseEntity<ExceptionResponse> handleRestResourceNotFoundException(RestResourceNotFoundException exp) {
		ExceptionResponse expResp = new ExceptionResponse();
		expResp.setCode(HttpStatus.NOT_FOUND.value());
		expResp.setException("RestResourceNotFoundException");
		expResp.setMessage(exp.getMessage());
		return new ResponseEntity(expResp, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ AddressNotFoundException.class })
	public ResponseEntity<ExceptionResponse> handleAddressNotFoundException(AddressNotFoundException exp) {
		ExceptionResponse expResp = new ExceptionResponse();
		expResp.setCode(HttpStatus.NOT_FOUND.value());
		expResp.setException("AddressNotFoundException");
		expResp.setMessage(exp.getMessage());
		return new ResponseEntity(expResp, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ MemeberSalaryNotFoundException.class })
	public ResponseEntity<ExceptionResponse> handleMemeberSalaryNotFoundException(MemeberSalaryNotFoundException exp) {
		ExceptionResponse expResp = new ExceptionResponse();
		expResp.setCode(HttpStatus.NOT_FOUND.value());
		expResp.setException("MemberSalaryNotFoundException");
		expResp.setMessage(exp.getMessage());
		return new ResponseEntity(expResp, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ HttpMessageNotReadableException.class })
	public ResponseEntity<ExceptionResponse> handleHttpMessageNotReadableException(
			HttpMessageNotReadableException exp) {
		ExceptionResponse expResp = new ExceptionResponse();
		expResp.setCode(HttpStatus.BAD_REQUEST.value());
		expResp.setException("HttpMessageNotReadableException");
		expResp.setMessage(exp.getMessage() + "\n" + exp.getCause());
		return new ResponseEntity(expResp, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ JsonMappingException.class })
	public ResponseEntity<ExceptionResponse> handleJsonMappingException(JsonMappingException exp) {
		ExceptionResponse expResp = new ExceptionResponse();
		expResp.setCode(HttpStatus.BAD_REQUEST.value());
		expResp.setException("JsonMappingException");
		expResp.setMessage(exp.getMessage() + "\n" + exp.getCause());
		return new ResponseEntity(expResp, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ IOException.class })
	public ResponseEntity<ExceptionResponse> handleIOException(IOException exp) {
		ExceptionResponse expResp = new ExceptionResponse();
		expResp.setCode(HttpStatus.BAD_REQUEST.value());
		expResp.setException("IOException");
		expResp.setMessage(exp.getMessage() + "\n" + exp.getCause());
		return new ResponseEntity(expResp, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ MissingServletRequestParameterException.class })
	public ResponseEntity<ExceptionResponse> handleMissingServletRequestParameterException(
			MissingServletRequestParameterException exp) {
		ExceptionResponse expResp = new ExceptionResponse();
		expResp.setCode(HttpStatus.BAD_REQUEST.value());
		expResp.setException("MissingServletRequestParameterException");
		expResp.setMessage(exp.getMessage());
		log.info("inside exception handler for missing servlet request parameter");
		return new ResponseEntity(expResp, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ BeanNotFoundException.class })
	public ResponseEntity<ExceptionResponse> handleBeanNotFoundException(BeanNotFoundException beanExp) {
		ExceptionResponse expResp = new ExceptionResponse();
		expResp.setCode(HttpStatus.BAD_REQUEST.value());
		expResp.setException("BeanNotFoundException");
		expResp.setMessage(beanExp.getMessage());
		return new ResponseEntity(expResp, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<ExceptionResponse> handle(HttpMessageConversionException e) throws Throwable {
		Throwable cause = e.getCause();
		if (cause instanceof UnrecognizedPropertyException) {
			return this.handle((UnrecognizedPropertyException) cause);
		} else {
			ExceptionResponse expResp = new ExceptionResponse();
			expResp.setCode(HttpStatus.BAD_REQUEST.value());
			expResp.setException(e.getMessage() + " caused by " + cause);
			return new ResponseEntity(expResp, HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<ExceptionResponse> handle(UnrecognizedPropertyException e) {
		ExceptionResponse expResp = new ExceptionResponse();
		expResp.setCode(HttpStatus.BAD_REQUEST.value());
		expResp.setException(e.getMessage() + " caused by " + e.getCause());
		return new ResponseEntity(expResp, HttpStatus.BAD_REQUEST);
	}
}