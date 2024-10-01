package com.microservice.user.microserviceuser.repository.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.user.microserviceuser.entities.UserEntity;

import java.util.Optional;

public interface iUserDAO extends JpaRepository<UserEntity,Integer>{

    public Optional<UserEntity> findOneByUsername(String username);

}
