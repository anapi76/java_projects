package com.microservice.auth.microserviceauth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.auth.microserviceauth.dto.AuthUserDTO;
import com.microservice.auth.microserviceauth.dto.AuthUserDTOController;
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

    /*
     * @PostMapping("/login")
     * public ResponseEntity<TokenDTO> login (@RequestBody AuthUserDTO authUserDto){
     * TokenDTO tokenDto=authUserService.login(authUserDto);
     * if(tokenDto==null){
     * return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
     * }
     * return new ResponseEntity<>(tokenDto, HttpStatus.OK);
     * }
     * 
     * @PostMapping("/")
     * public ResponseEntity<TokenDTO> validate (@RequestParam String token){
     * TokenDTO tokenDto=authUserService.validate(token);
     * if(tokenDto==null){
     * return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
     * }
     * return new ResponseEntity<>(tokenDto, HttpStatus.OK);
     * }
     */

    @PostMapping("/create")
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

}
