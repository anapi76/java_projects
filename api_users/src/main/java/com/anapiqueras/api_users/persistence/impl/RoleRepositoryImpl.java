package com.anapiqueras.api_users.persistence.impl;

import org.springframework.stereotype.Repository;

import com.anapiqueras.api_users.domain.repository.iRoleRepository;
import com.anapiqueras.api_users.dto.RoleDTO;
import com.anapiqueras.api_users.exceptions.RoleNotFoundException;
import com.anapiqueras.api_users.mapper.RoleMapperDTO;
import com.anapiqueras.api_users.persistence.DAO.iRoleDAO;
import com.anapiqueras.api_users.persistence.model.RoleEntity;

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
