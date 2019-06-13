package com.example.controllers;

import com.example.entity.user.UserDTO;
import com.example.entity.user.UserEntity;
import com.example.entity.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userServiceImpl.getById(id));
    }

    @RequestMapping(value = "/users/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        return ResponseEntity.ok(userServiceImpl.getAll());
    }

    @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userServiceImpl.create(userDTO));
    }

    @RequestMapping(value = "/users/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO, @PathVariable("id") Long id) {
        return ResponseEntity.ok(userServiceImpl.update(userDTO, id));
    }
}
