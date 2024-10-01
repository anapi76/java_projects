package com.anapiqueras.api_users.repository;

import org.springframework.stereotype.Repository;

import com.anapiqueras.api_users.dto.UserDTO;
import com.anapiqueras.api_users.exceptions.UserNotFoundException;

import java.util.List;

@Repository
public interface iUserRepository{

    public UserDTO findUserByUsername(String username) throws UserNotFoundException;

    public List<UserDTO> findAll();

    public UserDTO findUserById(int id) throws UserNotFoundException;

    public UserDTO createUser(UserDTO user);

    public UserDTO updateUser(UserDTO userFound);

    public void deleteUserById(int id) throws UserNotFoundException;
}
