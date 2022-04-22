package com.training.service.productandservice.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.training.service.productandservice.model.UserResponse;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler{
	//value  = { IllegalArgumentException.class, IllegalStateException.class }
	  @ExceptionHandler(Exception.class)
		    protected ResponseEntity<ErrorMessage> someThingWentWrong(
		    		Exception ex) {
		  ErrorMessage errorMessage= new ErrorMessage(ex.getMessage(), "Exception occured and hence unable to continue");
		        return new  ResponseEntity<ErrorMessage>(errorMessage, new HttpHeaders(), HttpStatus.BAD_GATEWAY);
		    }
	  
	  @ExceptionHandler(UserNotFoundException.class)
	    protected ResponseEntity<UserResponse> userNotFound(
	    		Exception ex) {
	  ErrorMessage errorMessage= new ErrorMessage(ex.getMessage(), "Unable to find the user in our records");
	        return new  ResponseEntity<UserResponse>(new UserResponse(errorMessage), new HttpHeaders(), HttpStatus.BAD_REQUEST);
	    }
	  
	  @ExceptionHandler(RequestNotFoundException.class)
	    protected ResponseEntity<ErrorMessage> requestNotFound(
	    		Exception ex) {
	  ErrorMessage errorMessage= new ErrorMessage(ex.getMessage(), "Unable to find the request in our records");
	        return new  ResponseEntity<ErrorMessage>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	    }
	  
}
