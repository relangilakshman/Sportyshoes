package com.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoes.model.User;



public interface UserRepo extends JpaRepository<User, String>{

}
