package com.microservice.product.microserviceproduct.persistence.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.product.microserviceproduct.persistence.entity.TypeProductEntity;

public interface iTypeProductDAO extends JpaRepository<TypeProductEntity, Integer>{

}
