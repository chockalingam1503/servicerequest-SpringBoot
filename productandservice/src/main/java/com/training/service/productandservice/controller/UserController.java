package com.training.service.productandservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicerequest")
public class UserController {

@GetMapping("/test")
public ResponseEntity<String> test(){
	return new ResponseEntity<>(HttpStatus.OK);
	
}
	
	
}
