package com.training.service.productandservice.dao;

import org.springframework.data.repository.CrudRepository;

import com.training.service.productandservice.model.Request;

public interface RequestRepository extends CrudRepository<Request, Integer> {

}
