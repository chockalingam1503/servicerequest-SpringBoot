package com.training.service.productandservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.service.productandservice.exceptions.RequestNotFoundException;
import com.training.service.productandservice.exceptions.UserNotFoundException;
import com.training.service.productandservice.model.Request;
import com.training.service.productandservice.model.User;
import com.training.service.productandservice.service.RequestService;
import com.training.service.productandservice.service.UserService;

@RestController
@RequestMapping("/servicerequest")
public class RequestController {

	@Autowired
	UserService userService;

	@Autowired
	RequestService requestService;

	@GetMapping("/findRequestById")
	public ResponseEntity<Request> findRequestByid(@RequestParam(name = "requestId") int requestId) throws RequestNotFoundException {

		Optional<Request> request = requestService.findRequest(requestId);
		
		if(request.isPresent()) {
			return new ResponseEntity<Request>(request.get(), HttpStatus.OK);  
		} else {
			 throw new RequestNotFoundException("Invalid Request");
		}

	}

	@PostMapping("/raiserequest")
	public ResponseEntity<String> createRequest(@RequestBody Request request, @RequestParam(name = "userId") int id)
			throws UserNotFoundException {

		Optional<User> user1 = userService.findUser(id);
		Request requst = null;
		if (user1.isPresent()) {

			request.setUserId(id);
			requst = requestService.createRequest(request);

			return new ResponseEntity<String>(requst.toString(), HttpStatus.OK);
		} else {
			 throw new UserNotFoundException("Invalid user");
		}

	}

}
