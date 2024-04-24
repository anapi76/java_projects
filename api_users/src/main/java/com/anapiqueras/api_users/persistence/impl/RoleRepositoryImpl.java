package com.anapiqueras.api_users.persistence.impl;

import org.springframework.stereotype.Repository;

import com.anapiqueras.api_users.domain.repository.iRoleRepository;
import com.anapiqueras.api_users.dto.RoleDTO;
import com.anapiqueras.api_users.exceptions.RoleNotFoundException;
import com.anapiqueras.api_users.mapper.DTOMapperRole;
import com.anapiqueras.api_users.mapper.RoleMapperDTO;
import com.anapiqueras.api_users.persistence.DAO.iRoleDAO;
import com.anapiqueras.api_users.persistence.model.RoleEntity;

@Repository
public class RoleRepositoryImpl implements iRoleRepository {

    public iRoleDAO roleDao;
    private DTOMapperRole dtoMapperRole;
    private RoleMapperDTO roleMapperDTO;

    public RoleRepositoryImpl(iRoleDAO roleDao,DTOMapperRole dtoMapperRole, RoleMapperDTO roleMapperDTO) {
        this.roleDao = roleDao;
        this.dtoMapperRole=dtoMapperRole;
        this.roleMapperDTO=roleMapperDTO;
    }

    @Override
    public RoleDTO findRoleById(int id) throws RoleNotFoundException {
        RoleEntity roleFound = roleDao.findById(id)
                .orElseThrow(() -> new RoleNotFoundException("Role not found for id: " + id));
        return roleMapperDTO.mapToRoleDto(roleFound);
    }


    /* @Override
    public List<RoleDTO> findAll() {
        List<RoleEntity> roles = roleDao.findAll();
        return roles.stream().map(p->roleMapperDTO.mapToRoleDto(p)).collect(Collectors.toList());
    } 

    
    @Override
    public RoleDTO createRole(RoleDTO roleDto) {
        RoleEntity role = dtoMapperRole.mapToRole(roleDto);
        role= roleDao.save(role);
        RoleDTO savedRoleDto = roleMapperDTO.mapToRoleDto(role);
        return savedRoleDto;
    }

    @Override
    public RoleDTO updateRole(RoleDTO roleDto) {
        RoleEntity role = dtoMapperRole.mapToRole(roleDto);
        role= roleDao.save(role);
        RoleDTO savedRoleDto = roleMapperDTO.mapToRoleDto(role);
        return savedRoleDto;
    }

    @Override
    public void deleteRoleById(Long id) throws RoleNotFoundException {
        if(findRoleById(id)==null){
            new RoleNotFoundException("Role not found for id: " + id);
        }
        roleDao.deleteById(id);
    }
*/


    

}
