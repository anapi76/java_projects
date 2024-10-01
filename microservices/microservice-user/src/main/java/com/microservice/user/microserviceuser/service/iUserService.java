package com.microservice.user.microserviceuser.service;

import java.util.List;

import com.microservice.user.microserviceuser.dto.UserDTO;
import com.microservice.user.microserviceuser.exceptions.RoleNotFoundException;
import com.microservice.user.microserviceuser.exceptions.UserCantBeNullException;
import com.microservice.user.microserviceuser.exceptions.UserNotFoundException;


public interface iUserService {

    public UserDTO findUserByUsername(String username) throws UserNotFoundException;

    public List<UserDTO> findAll();

    public UserDTO findUserById(int id) throws UserNotFoundException;
    
    public UserDTO createUser(UserDTO user) throws UserCantBeNullException, RoleNotFoundException;
    
    public UserDTO updateUser(int id,UserDTO product) throws UserNotFoundException, RoleNotFoundException;
    
    public void deleteUserById(int id) throws UserNotFoundException;

}
