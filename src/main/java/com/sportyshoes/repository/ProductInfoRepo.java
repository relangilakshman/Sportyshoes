package com.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoes.model.ProductInfo;

public interface ProductInfoRepo extends JpaRepository<ProductInfo, Integer> {

}
