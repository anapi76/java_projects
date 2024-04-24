package com.anapiqueras.api_users.domain.repository;

import org.springframework.stereotype.Repository;

import com.anapiqueras.api_users.dto.RoleDTO;
import com.anapiqueras.api_users.exceptions.RoleNotFoundException;

//import java.util.List;

@Repository
public interface iRoleRepository{

    
    public RoleDTO findRoleById(int id) throws RoleNotFoundException;

    //public List<RoleDTO> findAll();

    //public UserDTO createUser(UserDTO user);

    //public UserDTO updateUser(UserDTO userFound);

    //public void deleteUserById(Long id) throws UserNotFoundException;
}
