package com.microservice.user.microserviceuser.mapper;

import org.springframework.stereotype.Component;

import com.microservice.user.microserviceuser.dto.RoleDTO;
import com.microservice.user.microserviceuser.persistence.entities.RoleEntity;


@Component
public class RoleMapperDTO {

    public RoleDTO mapToRoleDto(RoleEntity role) {
        RoleDTO roleDto = new RoleDTO(
                role.getIdRole(),
                role.getName());
        return roleDto;
    }
}
