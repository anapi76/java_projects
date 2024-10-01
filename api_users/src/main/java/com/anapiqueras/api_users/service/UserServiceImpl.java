package com.anapiqueras.api_users.domain.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.anapiqueras.api_users.domain.repository.iRoleRepository;
import com.anapiqueras.api_users.domain.repository.iUserRepository;
import com.anapiqueras.api_users.dto.RoleDTO;
import com.anapiqueras.api_users.dto.UserDTO;
import com.anapiqueras.api_users.exceptions.RoleNotFoundException;
import com.anapiqueras.api_users.exceptions.UserCantBeNullException;
import com.anapiqueras.api_users.exceptions.UserNotFoundException;

@Service
public class UserServiceImpl implements iUserService {

    public iUserRepository userRepository;
    public iRoleRepository roleRepository;

    public UserServiceImpl(iUserRepository userRepository, iRoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDTO findUserByUsername(String username) throws UserNotFoundException {
        UserDTO userFound = userRepository.findUserByUsername(username);
        return userFound;
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> users = userRepository.findAll();
        return users;
    }

    @Override
    public UserDTO findUserById(int id) throws UserNotFoundException {
        UserDTO userFound = userRepository.findUserById(id);
        return userFound;
    }

    @Override
    public UserDTO createUser(UserDTO userDto) throws UserCantBeNullException, RoleNotFoundException {
        if (userDto == null) {
            throw new UserCantBeNullException("User can't be null");
        }
        if (!validateUser(userDto)) {
            return null;
        }
        RoleDTO roleDto = roleRepository.findRoleById(userDto.getRoleDto().getIdRole());
        String hashedPassword = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
        userDto.setPassword(hashedPassword);
        userDto.setRoleDto(roleDto);
        UserDTO createdUser = userRepository.createUser(userDto);

        return createdUser;
    }

    @Override
    public UserDTO updateUser(int id, UserDTO userDto) throws UserNotFoundException, RoleNotFoundException {
        UserDTO userFound = userRepository.findUserById(id);
        userFound.setIdUser(id);
        userFound.setUsername(userDto.getUsername());
        userFound.setPassword(userDto.getPassword());
        userFound.setEmail(userDto.getEmail());
        RoleDTO roleDto = roleRepository.findRoleById(userDto.getRoleDto().getIdRole());
        userFound.setRoleDto(roleDto);
        UserDTO updatedUser = userRepository.updateUser(userFound);
        return updatedUser;
    }

    @Override
    public void deleteUserById(int id) throws UserNotFoundException {
        userRepository.deleteUserById(id);
    }

    public Boolean validateUser(UserDTO userDto) {
        return (this.validateUsernameIsUnic(userDto.getUsername()) && userDto.getUsername() != null
                && !userDto.getUsername().isEmpty() && userDto.getPassword() != null
                && !userDto.getPassword().isEmpty() && userDto.getEmail() != null && !userDto.getEmail().isEmpty()
                && userDto.getRoleDto() != null);
    }

    public Boolean validateUsernameIsUnic(String username) {
        try {
            userRepository.findUserByUsername(username);
            return false;
        } catch (UserNotFoundException ex) {
            return true;
        }
    }
   
}
