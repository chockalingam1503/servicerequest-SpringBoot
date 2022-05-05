package com.training.service.productandservice.controller;

import java.util.ArrayList;
import java.util.List;
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

import com.training.service.productandservice.data.User;
import com.training.service.productandservice.data.UserResponse;
import com.training.service.productandservice.exceptions.UserNotAddedException;
import com.training.service.productandservice.exceptions.UserNotFoundException;
import com.training.service.productandservice.service.RequestService;
import com.training.service.productandservice.service.UserService;

@RestController
@RequestMapping("/servicerequest")
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	RequestService requestService;

	@GetMapping("/findUserById")
	public ResponseEntity<UserResponse> findUserByid(@RequestParam(name = "userId") int userId)
			throws UserNotFoundException {

		Optional<User> user1 = userService.findUser(userId);

		if (user1.isPresent()) {
			return new ResponseEntity<UserResponse>(new UserResponse(user1.get()), HttpStatus.OK);
		} else {
			throw new UserNotFoundException("Invalid User id");
		}

	}

	@GetMapping("/findallusers")
	public ResponseEntity<UserResponse> findAllUsers() throws Exception {

		Iterable<User> userItreable = userService.findAllUsers();
		List<User> result = new ArrayList<User>();

		// userItreable.forEach(user->result.add(user)); this lambda can be written with
		// method refrencing as below
		userItreable.forEach(result::add);

		if (result.size() > 0) {
			return new ResponseEntity<UserResponse>(new UserResponse(result), HttpStatus.OK);
		} else {
			throw new Exception("Zero users found");
		}

	}

	@PostMapping("/addUser")
	public ResponseEntity<UserResponse> createUser(@RequestBody User user) throws Exception {

		User user1 = userService.createUser(user);

		if (user1.getId() > 0) {
			return new ResponseEntity<UserResponse>(new UserResponse(user1), HttpStatus.OK);
		} else {
			throw new UserNotAddedException("Unable to add the user");
		}

	}

}
