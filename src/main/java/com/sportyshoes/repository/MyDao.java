package com.sportyshoes.repository;

import org.springframework.data.repository.CrudRepository;

import com.sportyshoes.model.MyModel;

/**
 *
 * @author Vasu Rajput
 */
public interface MyDao extends CrudRepository<MyModel, Long> {
    
}