package com.training.service.productandservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.service.productandservice.data.Request;
import com.training.service.productandservice.data.RequestResponse;
import com.training.service.productandservice.data.User;
import com.training.service.productandservice.data.UserResponse;
import com.training.service.productandservice.exceptions.RequestNotFoundException;
import com.training.service.productandservice.exceptions.UserNotFoundException;
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
	public ResponseEntity<RequestResponse> findRequestByid(@RequestParam(name = "requestId") int requestId)
			throws RequestNotFoundException {

		Optional<Request> request = requestService.findRequest(requestId);

		if (request.isPresent()) {
			return new ResponseEntity<RequestResponse>(new RequestResponse(request.get()), HttpStatus.OK);
		} else {
			throw new RequestNotFoundException("Request id " + requestId + " not found in our records");
		}

	}
	
	@GetMapping("/findRequestByIdPathParam/{requestid}")
	public ResponseEntity<RequestResponse> findRequestByidPathParam(@PathVariable ("requestid") int requestId)
			throws RequestNotFoundException {

		Optional<Request> request = requestService.findRequest(requestId);

		if (request.isPresent()) {
			return new ResponseEntity<RequestResponse>(new RequestResponse(request.get()), HttpStatus.OK);
		} else {
			throw new RequestNotFoundException("Request id " + requestId + " not found in our records");
		}

	}

	@GetMapping("/findAllRequestsByUserId")
	public ResponseEntity<RequestResponse> findRequestsByUserid(@RequestParam(name = "userid") int userId)
			throws RequestNotFoundException {

		List<Request> requests = requestService.findAllRequestByUserId(userId);

		if (requests.size() > 0) {
			return new ResponseEntity<RequestResponse>(new RequestResponse(requests), HttpStatus.OK);
		} else {
			throw new RequestNotFoundException("User id " + userId + " did not have any requests");
		}

	}

	@GetMapping("/findallrequests")
	public ResponseEntity<RequestResponse> findAllrequests() throws Exception {

		Iterable<Request> requestItreable = requestService.findAllRequests();
		List<Request> result = new ArrayList<Request>();

		requestItreable.forEach(result::add);

		if (result.size() > 0) {
			return new ResponseEntity<RequestResponse>(new RequestResponse(result), HttpStatus.OK);
		} else {
			throw new Exception("Zero Requests found");
		}

	}

	@PostMapping("/raiserequest")
	public ResponseEntity<RequestResponse> createRequest(@RequestBody Request request,
			@RequestParam(name = "userId") int id) throws UserNotFoundException {

		Optional<User> user1 = userService.findUser(id);
		Request requst = null;
		if (user1.isPresent()) {

			request.setUserId(id);
			requst = requestService.createOrUpdateRequest(request);

			return new ResponseEntity<RequestResponse>(new RequestResponse(requst), HttpStatus.OK);
		} else {
			throw new UserNotFoundException("Invalid user, hence request cannot be raised");
		}

	}

	@Transactional
	@PutMapping("/updaterequest")
	public ResponseEntity<RequestResponse> updateRequest(@RequestBody Request request) throws Exception {
		Request request1 = null;
		if (request.getId() > 0) {
			request1 = requestService.createOrUpdateRequest(request);
		} else {
			throw new Exception("Invalid Request, hence Request cannot be updated");
		}

		if (request1.getId() > 0) {

			return new ResponseEntity<RequestResponse>(new RequestResponse(request1), HttpStatus.OK);
		} else {
			throw new Exception("Invalid Request, hence Request cannot be updated");
		}

	}
	
	
	@PutMapping("/updaterequeststatus")
	public ResponseEntity<RequestResponse> updateRequestStatus(@RequestParam(name = "requestId") int requestId , @RequestParam(name = "newstatus") String newStatus) throws Exception {
			
		Optional<Request> request = requestService.findRequest(requestId);
		
		if(request.isPresent()) {
			request.get().setStatus(newStatus);
			Request request1 = requestService.createOrUpdateRequest(request.get());
			return new ResponseEntity<RequestResponse>(new RequestResponse(request1), HttpStatus.OK);
		} else {
			throw new Exception("Unable to update requst status , check the request id properly");
		}
		
	
	}

}
