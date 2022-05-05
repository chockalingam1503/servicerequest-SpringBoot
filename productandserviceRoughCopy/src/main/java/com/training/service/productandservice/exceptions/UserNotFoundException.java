package com.training.service.productandservice.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ResponseStatus(code= HttpStatus.CONFLICT, reason="No such Order")
public class UserNotFoundException extends Exception {

	public UserNotFoundException(String message) {
		super(message);
	}



	
}


