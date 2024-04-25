package com.microservice.auth.microserviceauth.mapper;

import org.springframework.stereotype.Component;

import com.microservice.auth.microserviceauth.dto.RoleDTO;
import com.microservice.auth.microserviceauth.entity.RoleEntity;

@Component
public class DTOMapperRole {

    public RoleEntity mapToRole(RoleDTO roleDto) {
        RoleEntity role = new RoleEntity(
                roleDto.getName());
        role.setIdRole(roleDto.getIdRole());
        return role;
    }
}
