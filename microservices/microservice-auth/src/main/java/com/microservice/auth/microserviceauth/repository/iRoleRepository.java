package com.microservice.auth.microserviceauth.repository;

import org.springframework.stereotype.Repository;

import com.microservice.auth.microserviceauth.dto.RoleDTO;
import com.microservice.auth.microserviceauth.exceptions.RoleNotFoundException;

public interface iRoleRepository {

    //public RoleDTO findRoleByName(String name);
    public RoleDTO findRoleById(int id) throws RoleNotFoundException;

}
