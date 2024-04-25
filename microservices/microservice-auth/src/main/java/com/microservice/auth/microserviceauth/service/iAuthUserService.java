package com.microservice.auth.microserviceauth.service;

import com.microservice.auth.microserviceauth.dto.AuthUserDTO;
import com.microservice.auth.microserviceauth.exceptions.AuthUserCantBeNullException;
import com.microservice.auth.microserviceauth.exceptions.RoleNotFoundException;

public interface iAuthUserService {

    public AuthUserDTO create(AuthUserDTO authUserDto) throws AuthUserCantBeNullException, RoleNotFoundException;
}
