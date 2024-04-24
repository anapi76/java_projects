package com.microservice.user.microserviceuser.mapper;

import org.springframework.stereotype.Component;

import com.microservice.user.microserviceuser.dto.RoleDTO;
import com.microservice.user.microserviceuser.dto.UserDTO;
import com.microservice.user.microserviceuser.persistence.entities.UserEntity;


@Component
public class UserMapperDTO {

    private RoleMapperDTO roleMapperDTO = new RoleMapperDTO();

    public UserDTO mapToUserDto(UserEntity user) {
        RoleDTO role = roleMapperDTO.mapToRoleDto(user.getRole());
        UserDTO userDto = new UserDTO(
                user.getIdUser(),
                user.getName(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.isEnabled(),
                user.isAccountNoExpired(),
                user.isAccountNoLocked(),
                user.isCredentialNoExpired(),
                role);
        return userDto;
    }
}
