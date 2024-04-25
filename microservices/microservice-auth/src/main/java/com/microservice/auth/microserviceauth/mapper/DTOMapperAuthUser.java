package com.microservice.auth.microserviceauth.mapper;

import org.springframework.stereotype.Component;

import com.microservice.auth.microserviceauth.dto.AuthUserDTO;
import com.microservice.auth.microserviceauth.entity.AuthUserEntity;
import com.microservice.auth.microserviceauth.entity.RoleEntity;



@Component
public class DTOMapperAuthUser {

    private DTOMapperRole dtoMapperRole=new DTOMapperRole();

    public AuthUserEntity mapToAuthUser(AuthUserDTO authUserDto) {
       RoleEntity role=dtoMapperRole.mapToRole(authUserDto.getRole());
       AuthUserEntity authUser=new AuthUserEntity(
            authUserDto.getUsername(),
            authUserDto.getPassword(),
            role);
            authUser.setIdAuth(authUserDto.getIdUser());
       /*      authUser.setEnabled(authUserDto.isEnabled());
            authUser.setAccountNoExpired(authUserDto.isAccountNoExpired());
            authUser.setAccountNoLocked(authUserDto.isAccountNoLocked());
            authUser.setCredentialNoExpired(authUserDto.isCredentialNoExpired()); */
        return authUser;
    }
}
