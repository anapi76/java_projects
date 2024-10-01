package com.microservice.auth.microserviceauth.repository;

import org.springframework.stereotype.Repository;

import com.microservice.auth.microserviceauth.dto.AuthUserDTO;
import com.microservice.auth.microserviceauth.exceptions.AuthUserNotFoundException;

public interface iAuthUserRepository {

    public AuthUserDTO findAuthUserByUsername(String username) throws AuthUserNotFoundException;

    public AuthUserDTO create(AuthUserDTO authUserDto);
}
