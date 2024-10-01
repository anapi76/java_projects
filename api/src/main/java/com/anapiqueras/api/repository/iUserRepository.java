package com.anapiqueras.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anapiqueras.api.entity.UserEntity;

import java.util.Optional;

@Repository
public interface iUserRepository extends JpaRepository<UserEntity, Long> {
    public Optional<UserEntity> findOneByUsername(String username);
}
