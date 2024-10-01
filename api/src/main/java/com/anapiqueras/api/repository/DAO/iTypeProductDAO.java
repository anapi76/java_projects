package com.anapiqueras.api.persistence.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anapiqueras.api.persistence.model.TypeProductEntity;

public interface iTypeProductDAO extends JpaRepository<TypeProductEntity, Integer>{

}
