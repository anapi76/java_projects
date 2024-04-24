package com.anapiqueras.api_users.mapper;

import org.springframework.stereotype.Component;

import com.anapiqueras.api_users.dto.RoleDTO;
import com.anapiqueras.api_users.persistence.model.RoleEntity;

@Component
public class DTOMapperRole {

    public RoleEntity mapToRole(RoleDTO roleDto) {
        RoleEntity role = new RoleEntity(
                roleDto.getName());
        role.setIdRole(roleDto.getIdRole());
        return role;
    }
}
