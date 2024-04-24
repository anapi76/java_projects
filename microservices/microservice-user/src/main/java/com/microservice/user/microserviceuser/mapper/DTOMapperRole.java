package com.microservice.user.microserviceuser.mapper;

import org.springframework.stereotype.Component;

import com.microservice.user.microserviceuser.dto.RoleDTO;
import com.microservice.user.microserviceuser.persistence.entities.RoleEntity;



@Component
public class DTOMapperRole {

    public RoleEntity mapToRole(RoleDTO roleDto) {
        RoleEntity role = new RoleEntity(
                roleDto.getName());
        role.setIdRole(roleDto.getIdRole());
        return role;
    }
}
