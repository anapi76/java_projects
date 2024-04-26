package com.microservice.auth.microserviceauth.service;

import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Service;

import com.microservice.auth.microserviceauth.config.PasswordEncoderConfig;
import com.microservice.auth.microserviceauth.config.UserDetailServiceImpl;
import com.microservice.auth.microserviceauth.dto.AuthResponse;
import com.microservice.auth.microserviceauth.dto.AuthUserDTO;
import com.microservice.auth.microserviceauth.dto.LoginRequest;
import com.microservice.auth.microserviceauth.dto.RoleDTO;
import com.microservice.auth.microserviceauth.exceptions.AuthUserCantBeNullException;
import com.microservice.auth.microserviceauth.exceptions.AuthUserNotFoundException;
import com.microservice.auth.microserviceauth.exceptions.RoleNotFoundException;
import com.microservice.auth.microserviceauth.repository.iAuthUserRepository;
import com.microservice.auth.microserviceauth.repository.iRoleRepository;

@Service
public class AuthUserService implements iAuthUserService {

    private iAuthUserRepository authUserRepository;
    private PasswordEncoderConfig passwordEncoderConfig;
    private JwtService jwtService;
    public iRoleRepository roleRepository;
    private UserDetailServiceImpl userDetailsService;

    public AuthUserService(iAuthUserRepository authUserRepository, PasswordEncoderConfig passwordEncoderConfig,
            JwtService jwtService, iRoleRepository roleRepository, UserDetailServiceImpl userDetailsService) {
        this.authUserRepository = authUserRepository;
        this.passwordEncoderConfig = passwordEncoderConfig;
        this.jwtService = jwtService;
        this.roleRepository = roleRepository;
        this.userDetailsService=userDetailsService;
    }

    @Override
    public AuthUserDTO create(AuthUserDTO authUserDto) throws AuthUserCantBeNullException, RoleNotFoundException {
        if (authUserDto == null) {
            throw new AuthUserCantBeNullException("AuthUser can't be null");
        }
        if (!validateAuthUser(authUserDto)) {
            return null;
        }
        RoleDTO roleDto = roleRepository.findRoleById(authUserDto.getRole().getIdRole());
        String passwordEncode = passwordEncoderConfig.passwordEncoder().encode(authUserDto.getPassword());
        authUserDto.setPassword(passwordEncode);
        authUserDto.setRole(roleDto);
        AuthUserDTO authUserDtoCreated = authUserRepository.create(authUserDto);
        return authUserDtoCreated;
    }

    public AuthResponse login(LoginRequest loginRequest) {
        String username = loginRequest.username();
        String password = loginRequest.password();
        Authentication authentication = userDetailsService.authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accesToken = jwtService.generateToken(authentication);
        AuthResponse authResponse = new AuthResponse(username, "User logged succesfully", accesToken,
                true);
        return authResponse;
    }

    public void validate(String token){
        jwtService.validateToken(token);
    }

    public Boolean validateAuthUser(AuthUserDTO authUserDto) {
        return (this.validateUsernameIsUnic(authUserDto.getUsername()) && authUserDto.getUsername() != null
                && !authUserDto.getUsername().isEmpty() && authUserDto.getPassword() != null
                && !authUserDto.getPassword().isEmpty()
                && authUserDto.getRole() != null);
    }

    public Boolean validateUsernameIsUnic(String username) {
        try {
            authUserRepository.findAuthUserByUsername(username);
            return false;
        } catch (AuthUserNotFoundException ex) {
            return true;
        }
    }
    

}
