package com.example.controllers;

import com.example.entity.user.UserDTO;
import com.example.entity.user.UserEntity;
import com.example.entity.user.UserServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger("request-log");

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getEntityById(id));
    }

    @RequestMapping(value = "/users/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @RequestMapping(value = "/users/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO, @PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.updateUser(userDTO, id));
    }
}
