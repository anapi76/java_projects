package com.anapiqueras.api_users.repository.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anapiqueras.api_users.entity.RoleEntity;

public interface iRoleDAO extends JpaRepository<RoleEntity,Integer>{

}
