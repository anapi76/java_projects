package com.microservice.auth.microserviceauth.repository;

import org.springframework.stereotype.Repository;

import com.microservice.auth.microserviceauth.dto.AuthUserDTO;
import com.microservice.auth.microserviceauth.entity.AuthUserEntity;
import com.microservice.auth.microserviceauth.exceptions.AuthUserNotFoundException;
import com.microservice.auth.microserviceauth.mapper.AuthUserMapperDTO;
import com.microservice.auth.microserviceauth.mapper.DTOMapperAuthUser;
import com.microservice.auth.microserviceauth.repository.DAO.iAuthUserDAO;


@Repository
public class AuthUserRepositoryImpl implements iAuthUserRepository {

    public iAuthUserDAO authUserDao;
    private DTOMapperAuthUser dtoMapperAuthUser;
    private AuthUserMapperDTO authUserMapperDTO;

    public AuthUserRepositoryImpl(iAuthUserDAO authUserDao ,DTOMapperAuthUser dtoMapperAuthUser, AuthUserMapperDTO authUserMapperDTO ) {
        this.authUserDao = authUserDao;
       this.dtoMapperAuthUser=dtoMapperAuthUser;
        this.authUserMapperDTO=authUserMapperDTO; 
    } 

    @Override
    public AuthUserDTO findAuthUserByUsername(String username) throws AuthUserNotFoundException {
        AuthUserEntity authUserFound=authUserDao.findOneByUsername(username).orElseThrow(() -> new AuthUserNotFoundException("User not found for username: " + username));
        return authUserMapperDTO.mapToAuthUserDto(authUserFound);
    }


    @Override
    public AuthUserDTO create(AuthUserDTO authUserDto) {
        AuthUserEntity authUser = dtoMapperAuthUser.mapToAuthUser(authUserDto);
        authUser= authUserDao.save(authUser);
        AuthUserDTO savedAuthUserDto = authUserMapperDTO.mapToAuthUserDto(authUser);
        return savedAuthUserDto;
    }



    

}
