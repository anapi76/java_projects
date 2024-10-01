package com.anapiqueras.api_users.mapper;

import org.springframework.stereotype.Component;

import com.anapiqueras.api_users.dto.UserDTO;
import com.anapiqueras.api_users.entity.RoleEntity;
import com.anapiqueras.api_users.entity.UserEntity;

@Component
public class DTOMapperUser {

    private DTOMapperRole dtoMapperRole=new DTOMapperRole();

    public UserEntity mapToUser(UserDTO userDto) {
       RoleEntity role=dtoMapperRole.mapToRole(userDto.getRoleDto());
       UserEntity user=new UserEntity(
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
