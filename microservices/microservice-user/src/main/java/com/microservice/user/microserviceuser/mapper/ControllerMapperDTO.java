package com.microservice.user.microserviceuser.mapper;

import org.springframework.stereotype.Component;

import com.microservice.user.microserviceuser.dto.RoleDTO;
import com.microservice.user.microserviceuser.dto.UserDTO;
import com.microservice.user.microserviceuser.dto.UserDTOController;


@Component
public class ControllerMapperDTO {

    public UserDTO mapToUserDto(UserDTOController userDtoController) {
        RoleDTO roleDto= new RoleDTO();
        if(userDtoController.getRole()!=null){
           roleDto = new RoleDTO(userDtoController.getRole());
        }
            UserDTO userDto = new UserDTO(
            userDtoController.getIdUser(),
            userDtoController.getName(),
            userDtoController.getUsername(),
            userDtoController.getPassword(),
            userDtoController.getEmail(),
            roleDto);
        return userDto;
    }
}
