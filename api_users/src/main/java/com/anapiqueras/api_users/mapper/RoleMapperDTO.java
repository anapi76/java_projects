package com.anapiqueras.api_users.mapper;

import org.springframework.stereotype.Component;

import com.anapiqueras.api_users.dto.RoleDTO;
import com.anapiqueras.api_users.persistence.model.RoleEntity;

@Component
public class RoleMapperDTO {

    public RoleDTO mapToRoleDto(RoleEntity role) {
        RoleDTO roleDto = new RoleDTO(
                role.getIdRole(),
                role.getName());
        return roleDto;
    }
}
