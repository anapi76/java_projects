package com.anapiqueras.api_users.persistence.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anapiqueras.api_users.persistence.model.RoleEntity;

public interface iRoleDAO extends JpaRepository<RoleEntity,Integer>{

}
