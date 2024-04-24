package com.anapiqueras.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anapiqueras.api.domain.repository.iUserRepository;
import com.anapiqueras.api.persistence.model.UserEntity;

@RestController
@RequestMapping("/users")
public class UserController {

    public iUserRepository userRepository;

    public UserController(iUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping()
    public ResponseEntity<List<UserEntity>> findAll() {
        List<UserEntity> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
