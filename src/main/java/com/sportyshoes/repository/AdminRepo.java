package com.sportyshoes.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import com.sportyshoes.model.AdminModel;

public interface AdminRepo extends JpaRepository<AdminModel, String>{
	
	
	@Transactional
	@Modifying
	@Query("UPDATE AdminModel SET password = :pass WHERE userId = :userid")
	public Integer updatPasswordByUserId(String pass,String userid);

}
