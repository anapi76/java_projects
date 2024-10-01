package com.anapiqueras.api.repository.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anapiqueras.api.entity.ProductEntity;

public interface iProductDAO extends JpaRepository<ProductEntity, Integer>{

}
