package com.training.service.productandservice.dao;

import org.springframework.data.repository.CrudRepository;

import com.training.service.productandservice.model.User;


public interface UserRepository extends CrudRepository<User, Integer>{

}
