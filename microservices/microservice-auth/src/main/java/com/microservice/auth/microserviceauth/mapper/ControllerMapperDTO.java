package com.microservice.auth.microserviceauth.mapper;

import org.springframework.stereotype.Component;

import com.microservice.auth.microserviceauth.dto.AuthUserDTO;
import com.microservice.auth.microserviceauth.dto.AuthUserDTOController;
import com.microservice.auth.microserviceauth.dto.RoleDTO;

@Component
public class ControllerMapperDTO {

    public AuthUserDTO mapToAuthUserDto(AuthUserDTOController authUserDtoController) {
        RoleDTO roleDto = new RoleDTO();
        if (authUserDtoController.getRole() != null) {
            roleDto = new RoleDTO(authUserDtoController.getRole());
        }
        AuthUserDTO authUserDto = new AuthUserDTO(
                authUserDtoController.getIdUser(),
                authUserDtoController.getUsername(),
                authUserDtoController.getPassword(),
                roleDto);
        return authUserDto;
    }
}
