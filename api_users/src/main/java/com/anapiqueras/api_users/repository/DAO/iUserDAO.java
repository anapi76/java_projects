package com.anapiqueras.api_users.repository.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anapiqueras.api_users.entity.UserEntity;
import java.util.Optional;

public interface iUserDAO extends JpaRepository<UserEntity,Integer>{

    public Optional<UserEntity> findOneByUsername(String username);

}
