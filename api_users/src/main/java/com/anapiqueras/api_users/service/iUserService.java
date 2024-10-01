package com.anapiqueras.api_users.domain.service;

import java.util.List;

import com.anapiqueras.api_users.dto.UserDTO;
import com.anapiqueras.api_users.exceptions.RoleNotFoundException;
import com.anapiqueras.api_users.exceptions.UserCantBeNullException;
import com.anapiqueras.api_users.exceptions.UserNotFoundException;

public interface iUserService {

    public UserDTO findUserByUsername(String username) throws UserNotFoundException;

    public List<UserDTO> findAll();

    public UserDTO findUserById(int id) throws UserNotFoundException;
    
    public UserDTO createUser(UserDTO user) throws UserCantBeNullException, RoleNotFoundException;
    
    public UserDTO updateUser(int id,UserDTO product) throws UserNotFoundException, RoleNotFoundException;
    
    public void deleteUserById(int id) throws UserNotFoundException;

}
