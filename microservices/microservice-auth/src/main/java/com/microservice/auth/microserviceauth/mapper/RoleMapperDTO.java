package com.microservice.auth.microserviceauth.mapper;

import org.springframework.stereotype.Component;

import com.microservice.auth.microserviceauth.dto.RoleDTO;
import com.microservice.auth.microserviceauth.entity.RoleEntity;

@Component
public class RoleMapperDTO {

    public RoleDTO mapToRoleDto(RoleEntity role) {
        RoleDTO roleDto = new RoleDTO(
                role.getIdRole(),
                role.getName());
        return roleDto;
    }
}
