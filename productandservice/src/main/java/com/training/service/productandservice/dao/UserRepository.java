package com.training.service.productandservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.service.productandservice.data.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	

	
	User findByUsername(String username);
	

}
