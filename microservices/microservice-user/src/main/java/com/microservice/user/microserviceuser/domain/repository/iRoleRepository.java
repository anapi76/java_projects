package com.microservice.user.microserviceuser.domain.repository;

import org.springframework.stereotype.Repository;

import com.microservice.user.microserviceuser.dto.RoleDTO;
import com.microservice.user.microserviceuser.exceptions.RoleNotFoundException;

//import java.util.List;

@Repository
public interface iRoleRepository {

    public RoleDTO findRoleByName(String name) throws RoleNotFoundException;

    public RoleDTO findRoleById(int id) throws RoleNotFoundException;

     /*   public List<RoleDTO> findAll();

    public RoleDTO createRole(RoleDTO role);

    public RoleDTO updateRole(RoleDTO role);

    public void deleteRoleById(int id) throws RoleNotFoundException; */
}
