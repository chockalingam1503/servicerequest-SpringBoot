package com.training.service.productandservice.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.training.service.productandservice.data.RequestResponse;
import com.training.service.productandservice.data.UserResponse;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {
	// value = { IllegalArgumentException.class, IllegalStateException.class }
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<UserResponse> someThingWentWrong(Exception ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), "Exception occured and hence unable to continue");
		return new ResponseEntity<UserResponse>(new UserResponse(errorMessage), new HttpHeaders(),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserNotFoundException.class)
	protected ResponseEntity<UserResponse> userNotFound(Exception ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), "Unable to find the user in our records");
		return new ResponseEntity<UserResponse>(new UserResponse(errorMessage), new HttpHeaders(),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserNotAddedException.class)
	protected ResponseEntity<UserResponse> userNotAdded(Exception ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), "Unable to add the user in to the system");
		return new ResponseEntity<UserResponse>(new UserResponse(errorMessage), new HttpHeaders(),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RequestNotFoundException.class)
	protected ResponseEntity<RequestResponse> requestNotFound(Exception ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), "Unable to find the request in our records");
		return new ResponseEntity<RequestResponse>(new RequestResponse(errorMessage), new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RequestNotAddedException.class)
	protected ResponseEntity<RequestResponse> requestNotAdded(Exception ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), "Unable to add the request in to the system");
		return new ResponseEntity<RequestResponse>(new RequestResponse(errorMessage), new HttpHeaders(),
				HttpStatus.NOT_FOUND);
	}

}
