package com.training.service.productandservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.service.productandservice.model.User;
import com.training.service.productandservice.service.RequestService;
import com.training.service.productandservice.service.UserService;

@RestController
@RequestMapping("/servicerequest")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	RequestService requestService;


	@PostMapping("/findUserById")
	public ResponseEntity<String> findUserByid(@RequestParam(name = "userId") int userId) {

		Optional<User> user1 = userService.findUser(userId);

		return new ResponseEntity<String>(user1.toString(), HttpStatus.OK);

	}

	@PostMapping("/addUser")
	public ResponseEntity<String> createUser(@RequestBody User user) {

		User user1 = userService.createUser(user);

		return new ResponseEntity<String>(user1.toString(), HttpStatus.OK);

	}



}
