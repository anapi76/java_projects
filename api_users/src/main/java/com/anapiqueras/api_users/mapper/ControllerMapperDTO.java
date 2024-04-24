package com.anapiqueras.api_users.mapper;

import org.springframework.stereotype.Component;

import com.anapiqueras.api_users.controller.dto.UserDTOController;
import com.anapiqueras.api_users.dto.RoleDTO;
import com.anapiqueras.api_users.dto.UserDTO;

@Component
public class ControllerMapperDTO {

    public UserDTO mapToUserDto(UserDTOController userDtoController) {
        RoleDTO roleDto= new RoleDTO();
        if(userDtoController.getRole()!=null){
           roleDto = new RoleDTO(userDtoController.getRole());
        }
            UserDTO userDto = new UserDTO(
            userDtoController.getIdUser(),
            userDtoController.getUsername(),
            userDtoController.getPassword(),
            userDtoController.getEmail(),
            roleDto);
        return userDto;
    }
}
