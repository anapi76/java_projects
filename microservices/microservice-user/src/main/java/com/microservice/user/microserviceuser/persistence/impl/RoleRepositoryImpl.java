package com.microservice.user.microserviceuser.persistence.impl;

import org.springframework.stereotype.Repository;

import com.microservice.user.microserviceuser.domain.repository.iRoleRepository;
import com.microservice.user.microserviceuser.dto.RoleDTO;
import com.microservice.user.microserviceuser.exceptions.RoleNotFoundException;
import com.microservice.user.microserviceuser.mapper.RoleMapperDTO;
import com.microservice.user.microserviceuser.persistence.DAO.iRoleDAO;
import com.microservice.user.microserviceuser.persistence.entities.RoleEntity;

@Repository
public class RoleRepositoryImpl implements iRoleRepository {

    public iRoleDAO roleDao;

    private RoleMapperDTO roleMapperDTO;

    public RoleRepositoryImpl(iRoleDAO roleDao,RoleMapperDTO roleMapperDTO) {
        this.roleDao = roleDao;
        this.roleMapperDTO=roleMapperDTO;
    }

    @Override
    public RoleDTO findRoleById(int id) throws RoleNotFoundException {
        RoleEntity roleFound = roleDao.findById(id)
                .orElseThrow(() -> new RoleNotFoundException("Role not found for id: " + id));
        return roleMapperDTO.mapToRoleDto(roleFound);
    }

    @Override
    public RoleDTO findRoleByName(String name) throws RoleNotFoundException {
        RoleEntity roleFound = roleDao.findOneByName(name)
                .orElseThrow(() -> new RoleNotFoundException("Role not found for name: " + name));
        return roleMapperDTO.mapToRoleDto(roleFound);
    }

}
