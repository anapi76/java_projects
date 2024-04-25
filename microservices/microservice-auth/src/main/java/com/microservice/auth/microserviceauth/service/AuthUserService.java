package com.microservice.auth.microserviceauth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.microservice.auth.microserviceauth.dto.AuthUserDTO;
import com.microservice.auth.microserviceauth.dto.RoleDTO;
import com.microservice.auth.microserviceauth.exceptions.AuthUserCantBeNullException;
import com.microservice.auth.microserviceauth.exceptions.AuthUserNotFoundException;
import com.microservice.auth.microserviceauth.exceptions.RoleNotFoundException;
import com.microservice.auth.microserviceauth.repository.iAuthUserRepository;
import com.microservice.auth.microserviceauth.repository.iRoleRepository;
import com.microservice.auth.microserviceauth.security.JwtProvider;
import com.microservice.auth.microserviceauth.security.PasswordEncoderConfig;

@Service
public class AuthUserService implements iAuthUserService{

    private iAuthUserRepository authUserRepository;
    private PasswordEncoderConfig passwordEncoder;
    private JwtProvider jwtProvider;
    public iRoleRepository roleRepository;

    public AuthUserService(iAuthUserRepository authUserRepository, PasswordEncoderConfig passwordEncoder,
            JwtProvider jwtProvider, iRoleRepository roleRepository) {
        this.authUserRepository = authUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
        this.roleRepository = roleRepository;
    }

    /*
     * public TokenDTO login(@RequestBody AuthUserDTO authUserDto) {
     * TokenDTO tokenDto = authUserService.login(authUserDto);
     * if (tokenDto == null) {
     * return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
     * }
     * return new ResponseEntity<>(tokenDto, HttpStatus.OK);
     * }
     * 
     * public TokenDTO validate(@RequestParam String token) {
     * TokenDTO tokenDto = authUserService.validate(token);
     * if (tokenDto == null) {
     * return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
     * }
     * return new ResponseEntity<>(tokenDto, HttpStatus.OK);
     * }
     */

    @Override
    public AuthUserDTO create(AuthUserDTO authUserDto) throws AuthUserCantBeNullException, RoleNotFoundException {
        if (authUserDto == null) {
            throw new AuthUserCantBeNullException("AuthUser can't be null");
        }
        if (!validateAuthUser(authUserDto)) {
            return null;
        }
        RoleDTO roleDto = roleRepository.findRoleById(authUserDto.getRole().getIdRole());
        String passwordEncode = passwordEncoder.passwordEncoder().encode(authUserDto.getPassword());
        authUserDto.setPassword(passwordEncode);
        authUserDto.setRole(roleDto);
        AuthUserDTO authUserDtoCreated = authUserRepository.create(authUserDto);
        return authUserDtoCreated;
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
