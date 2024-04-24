package com.microservice.user.microserviceuser.persistence.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.user.microserviceuser.persistence.entities.RoleEntity;

public interface iRoleDAO extends JpaRepository<RoleEntity, Integer> {
    public Optional<RoleEntity> findOneByName(String name);

}
