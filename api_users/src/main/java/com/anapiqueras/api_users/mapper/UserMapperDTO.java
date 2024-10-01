package com.anapiqueras.api_users.mapper;

import org.springframework.stereotype.Component;

import com.anapiqueras.api_users.dto.RoleDTO;
import com.anapiqueras.api_users.dto.UserDTO;
import com.anapiqueras.api_users.entity.UserEntity;

@Component
public class UserMapperDTO {

    private RoleMapperDTO roleMapperDTO = new RoleMapperDTO();

    public UserDTO mapToUserDto(UserEntity user) {
        RoleDTO role = roleMapperDTO.mapToRoleDto(user.getRole());
        UserDTO userDto = new UserDTO(
                user.getIdUser(),
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
