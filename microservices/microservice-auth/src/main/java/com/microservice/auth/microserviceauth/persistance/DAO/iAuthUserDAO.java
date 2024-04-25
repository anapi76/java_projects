package com.microservice.auth.microserviceauth.persistance.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.auth.microserviceauth.entity.AuthUserEntity;

import java.util.Optional;

public interface iAuthUserDAO extends JpaRepository<AuthUserEntity,Integer>{

    public Optional<AuthUserEntity> findOneByUsername(String username);

}
