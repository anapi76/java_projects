package com.microservice.product.microserviceproduct.persistence.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.product.microserviceproduct.persistence.entity.ProductEntity;

public interface iProductDAO extends JpaRepository<ProductEntity, Integer>{

}
