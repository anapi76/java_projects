package com.microservice.auth.microserviceauth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.exceptions.JWTVerificationException;

import com.microservice.auth.microserviceauth.dto.AuthResponse;
import com.microservice.auth.microserviceauth.dto.AuthUserDTO;
import com.microservice.auth.microserviceauth.dto.AuthUserDTOController;
import com.microservice.auth.microserviceauth.dto.LoginRequest;
import com.microservice.auth.microserviceauth.dto.TokenDTO;
import com.microservice.auth.microserviceauth.exceptions.AuthUserCantBeNullException;
import com.microservice.auth.microserviceauth.exceptions.RoleNotFoundException;
import com.microservice.auth.microserviceauth.mapper.ControllerMapperDTO;
import com.microservice.auth.microserviceauth.service.iAuthUserService;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

    private iAuthUserService authUserService;
    private ControllerMapperDTO controllerMapperDto;

    public AuthUserController(iAuthUserService authUserService, ControllerMapperDTO controllerMapperDto) {
        this.authUserService = authUserService;
        this.controllerMapperDto = controllerMapperDto;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthUserDTO> create(@RequestBody AuthUserDTOController authUserDtoController) {
        try {
            AuthUserDTO authUserDto = controllerMapperDto.mapToAuthUserDto(authUserDtoController);
            AuthUserDTO authUserDtoCreated = authUserService.create(authUserDto);
            if (authUserDtoCreated == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(authUserDtoCreated, HttpStatus.CREATED);
        } catch (AuthUserCantBeNullException auc) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (RoleNotFoundException rne) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        AuthResponse authResponse = authUserService.login(loginRequest);
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validate(@RequestBody TokenDTO tokenDTO) {
        try {
            authUserService.validate(tokenDTO.getToken());
            return new ResponseEntity<>("Valid token", HttpStatus.OK);
        } catch (JWTVerificationException jwte) {
            return new ResponseEntity<>("Invalid token, not authorized",HttpStatus.UNAUTHORIZED);
        }
    }
}
