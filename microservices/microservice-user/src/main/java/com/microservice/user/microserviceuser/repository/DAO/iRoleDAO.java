package com.microservice.user.microserviceuser.repository.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.user.microserviceuser.entities.RoleEntity;

public interface iRoleDAO extends JpaRepository<RoleEntity, Integer> {
    public Optional<RoleEntity> findOneByName(String name);

}
