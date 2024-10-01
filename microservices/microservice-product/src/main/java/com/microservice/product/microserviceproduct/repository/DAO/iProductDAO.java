package com.microservice.product.microserviceproduct.repository.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.product.microserviceproduct.entity.ProductEntity;

public interface iProductDAO extends JpaRepository<ProductEntity, Integer>{

}
