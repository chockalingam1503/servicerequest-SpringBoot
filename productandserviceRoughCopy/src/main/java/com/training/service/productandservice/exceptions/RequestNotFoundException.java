package com.training.service.productandservice.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ResponseStatus(code= HttpStatus.CONFLICT, reason="No such Request")
public class RequestNotFoundException extends Exception {

	public RequestNotFoundException(String message) {
		super(message);
	}



	
}
