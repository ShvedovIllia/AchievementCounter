package com.example.controllers;

import com.example.entity.user.UserDTO;
import com.example.entity.user.UserEntity;
import com.example.entity.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger("request-log");

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Long id) {
        logger.info("Request to get user with id = " + id);
        UserEntity userEntity = userService.getEntityById(id);
        logger.info("User with id " + id + "! \nName: " + userEntity.getName() + "\nPassword: " + userEntity.getPassword() +
                "\nDate of create: " + userEntity.getDateOfCreation() + "\nTeam id: " + userEntity.getTeamId());
        return ResponseEntity.ok(userEntity);
    }

    @RequestMapping(value = "/users/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        logger.info("Request to get all users");
        List<UserEntity> users = userService.getAllUsers();
        logger.info(users.size() + " users found!");
        return ResponseEntity.ok(users);
    }

    @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        logger.info("Request model:\nName: " + userDTO.getName() + "\nPassword: " + userDTO.getPassword() + "\nDate of create: "
                + userDTO.getDateOfCreation() + "\nTeam id: " + userDTO.getTeamId());
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @RequestMapping(value = "/users/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO, @PathVariable("id") Long id) {
        logger.info("Request to update user with id = " + id);
        return ResponseEntity.ok(userService.updateUser(userDTO, id));
    }
}
