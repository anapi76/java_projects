package com.microservice.user.microserviceuser.mapper;

import org.springframework.stereotype.Component;

import com.microservice.user.microserviceuser.dto.UserDTO;
import com.microservice.user.microserviceuser.entities.RoleEntity;
import com.microservice.user.microserviceuser.entities.UserEntity;

@Component
public class DTOMapperUser {

    private DTOMapperRole dtoMapperRole = new DTOMapperRole();

    public UserEntity mapToUser(UserDTO userDto) {
        RoleEntity role = dtoMapperRole.mapToRole(userDto.getRoleDto());
        UserEntity user = new UserEntity(
                userDto.getName(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getEmail(),
                role);
        user.setIdUser(userDto.getIdUser());
        user.setEnabled(userDto.isEnabled());
        user.setAccountNoExpired(userDto.isAccountNoExpired());
        user.setAccountNoLocked(userDto.isAccountNoLocked());
        user.setCredentialNoExpired(userDto.isCredentialNoExpired());
        return user;
    }
}
