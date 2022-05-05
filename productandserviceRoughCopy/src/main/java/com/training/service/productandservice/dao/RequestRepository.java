package com.training.service.productandservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.training.service.productandservice.data.Request;

public interface RequestRepository extends CrudRepository<Request, Integer> {
	
	@Query("FROM request where user_id= ?1")
	List<Request> findAllRequestByUserId(int id) ;
	


}
