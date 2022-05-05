package com.training.service.productandservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason="No such Order")
public class UserNotAddedException extends Exception {

	public UserNotAddedException(String message) {
		super(message);
	}



	
}
