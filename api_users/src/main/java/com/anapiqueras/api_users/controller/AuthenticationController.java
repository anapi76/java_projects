package com.anapiqueras.api_users.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anapiqueras.api_users.controller.dto.AuthResponse;
import com.anapiqueras.api_users.controller.dto.LoginRequest;
import com.anapiqueras.api_users.service.UserDetailServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")

public class AuthenticationController {

    private UserDetailServiceImpl userDetailService;

    public AuthenticationController(UserDetailServiceImpl userDetailService) {
        this.userDetailService = userDetailService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
            AuthResponse authResponse = this.userDetailService.loginUser(loginRequest);
            return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

}
