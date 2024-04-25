package com.microservice.auth.microserviceauth.persistance.impl;

import org.springframework.stereotype.Repository;

import com.microservice.auth.microserviceauth.dto.RoleDTO;
import com.microservice.auth.microserviceauth.entity.RoleEntity;
import com.microservice.auth.microserviceauth.exceptions.RoleNotFoundException;
import com.microservice.auth.microserviceauth.mapper.RoleMapperDTO;
import com.microservice.auth.microserviceauth.persistance.DAO.iRoleDAO;
import com.microservice.auth.microserviceauth.repository.iRoleRepository;

@Repository
public class RoleRepositoryImpl implements iRoleRepository {

    public iRoleDAO roleDao;
    private RoleMapperDTO roleMapperDTO;

    public RoleRepositoryImpl(iRoleDAO roleDao, RoleMapperDTO roleMapperDTO) {
        this.roleDao = roleDao;
        this.roleMapperDTO=roleMapperDTO;
    }

    @Override
    public RoleDTO findRoleById(int id) throws RoleNotFoundException {
        RoleEntity roleFound = roleDao.findById(id)
                .orElseThrow(() -> new RoleNotFoundException("Role not found for id: " + id));
        return roleMapperDTO.mapToRoleDto(roleFound);
    }
}
