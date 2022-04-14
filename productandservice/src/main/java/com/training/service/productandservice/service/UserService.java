package com.training.service.productandservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.service.productandservice.dao.RequestRepository;
import com.training.service.productandservice.dao.UserRepository;
import com.training.service.productandservice.model.Request;
import com.training.service.productandservice.model.User;

@Component
public class UserService {

	@Autowired
	UserRepository userDao;
	@Autowired
	RequestRepository requestDao;

	public User createUser(User user) {

		return userDao.save(user);

	}

	public Optional<User> findUser(int userId) {

		return userDao.findById(userId);

	}

}
