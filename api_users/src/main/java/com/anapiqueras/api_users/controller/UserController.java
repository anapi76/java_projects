package com.anapiqueras.api_users.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anapiqueras.api_users.controller.dto.UserDTOController;
import com.anapiqueras.api_users.domain.service.iUserService;
import com.anapiqueras.api_users.dto.UserDTO;
import com.anapiqueras.api_users.exceptions.RoleNotFoundException;
import com.anapiqueras.api_users.exceptions.UserCantBeNullException;
import com.anapiqueras.api_users.exceptions.UserNotFoundException;
import com.anapiqueras.api_users.mapper.ControllerMapperDTO;

@RestController
@RequestMapping("/users")
public class UserController {

    public iUserService userService;
    public ControllerMapperDTO controllerMapperDto;

    public UserController(iUserService userService, ControllerMapperDTO controllerMapperDto ) {
        this.userService = userService;
        this.controllerMapperDto=controllerMapperDto;
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable int id) {
        try {
            UserDTO user = userService.findUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UserNotFoundException pne) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTOController userDtoController) throws UserNotFoundException{
        try {
            UserDTO userDto = controllerMapperDto.mapToUserDto(userDtoController);
            UserDTO createdUser = userService.createUser(userDto);
            if (createdUser == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (UserCantBeNullException ucn) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (RoleNotFoundException rnf) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable int id,
            @RequestBody UserDTOController userDtoController) {
        try {
            UserDTO userDto = controllerMapperDto.mapToUserDto(userDtoController);
            UserDTO userUpdated = userService.updateUser(id, userDto);
            return new ResponseEntity<>(userUpdated, HttpStatus.CREATED);
        } catch (UserNotFoundException une) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RoleNotFoundException rnf) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id) {
        try {
            userService.deleteUserById(id);
            return new ResponseEntity<>("User deleted:" + id, HttpStatus.OK);
        } catch (UserNotFoundException une) {
            return new ResponseEntity<>("User not found for id: " + id, HttpStatus.NOT_FOUND);
        }
    } 
}
