package com.training.service.productandservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.service.productandservice.dao.RequestRepository;
import com.training.service.productandservice.data.Request;
import com.training.service.productandservice.data.User;

@Component
public class RequestService {

	@Autowired
	RequestRepository requestDao;

	public Request createOrUpdateRequest(Request request) {

		return requestDao.save(request);

	}

	public Optional<Request> findRequest(int id) {

		return requestDao.findById(id);

	}

	public Iterable<Request> findAllRequests() {

		return requestDao.findAll();

	}
	
//	public Iterable<Request> findAllOpenRequest() {
//
//		return requestDao.findAllOpenRequest();
//
//	}
	
	
	public List<Request> findAllRequestByUserId(int userId) {

		return requestDao.findAllRequestByUserId(userId);

	}
	
	
}
