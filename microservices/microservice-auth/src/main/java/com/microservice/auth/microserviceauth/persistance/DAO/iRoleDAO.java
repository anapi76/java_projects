package com.microservice.auth.microserviceauth.persistance.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.auth.microserviceauth.entity.RoleEntity;

public interface iRoleDAO extends JpaRepository<RoleEntity,Integer>{

}
