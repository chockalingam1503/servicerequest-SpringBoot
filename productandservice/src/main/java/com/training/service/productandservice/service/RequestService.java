package com.training.service.productandservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.service.productandservice.dao.RequestRepository;
import com.training.service.productandservice.model.Request;

@Component
public class RequestService {

	@Autowired
	RequestRepository requestDao;

	public Request createRequest(Request request) {

		return requestDao.save(request);

	}

	public Optional<Request> findRequest(int id) {

		return requestDao.findById(id);

	}

}
