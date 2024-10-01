package com.microservice.product.microserviceproduct.repository.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.product.microserviceproduct.entity.TypeProductEntity;

public interface iTypeProductDAO extends JpaRepository<TypeProductEntity, Integer>{

}
