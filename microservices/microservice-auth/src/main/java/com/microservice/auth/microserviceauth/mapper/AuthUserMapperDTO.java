package com.microservice.auth.microserviceauth.mapper;

import org.springframework.stereotype.Component;

import com.microservice.auth.microserviceauth.dto.AuthUserDTO;
import com.microservice.auth.microserviceauth.dto.RoleDTO;
import com.microservice.auth.microserviceauth.entity.AuthUserEntity;

@Component
public class AuthUserMapperDTO {

    private RoleMapperDTO roleMapperDTO = new RoleMapperDTO();

    public AuthUserDTO mapToAuthUserDto(AuthUserEntity authUser) {
        RoleDTO role = roleMapperDTO.mapToRoleDto(authUser.getRole());
        AuthUserDTO authUserDto = new AuthUserDTO(
            authUser.getIdAuth(),
            authUser.getUsername(),
            authUser.getPassword(),
            /*authUser.isEnabled(),
            authUser.isAccountNoExpired(),
            authUser.isAccountNoLocked(),
            authUser.isCredentialNoExpired(), */
                role);
        return authUserDto;
    }
}
