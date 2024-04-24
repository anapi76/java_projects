package com.microservice.user.microserviceuser.persistence.impl;

import org.springframework.stereotype.Repository;

import com.microservice.user.microserviceuser.domain.repository.iRoleRepository;
import com.microservice.user.microserviceuser.dto.RoleDTO;
import com.microservice.user.microserviceuser.exceptions.RoleNotFoundException;
import com.microservice.user.microserviceuser.mapper.DTOMapperRole;
import com.microservice.user.microserviceuser.mapper.RoleMapperDTO;
import com.microservice.user.microserviceuser.persistence.DAO.iRoleDAO;
import com.microservice.user.microserviceuser.persistence.entities.RoleEntity;

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

    @Override
    public RoleDTO findRoleByName(String name) throws RoleNotFoundException {
        RoleEntity roleFound = roleDao.findOneByName(name)
                .orElseThrow(() -> new RoleNotFoundException("Role not found for name: " + name));
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
