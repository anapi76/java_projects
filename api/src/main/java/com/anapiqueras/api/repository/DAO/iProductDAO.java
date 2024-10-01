package com.anapiqueras.api.persistence.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anapiqueras.api.persistence.model.ProductEntity;

public interface iProductDAO extends JpaRepository<ProductEntity, Integer>{

}
