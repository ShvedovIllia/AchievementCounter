package com.example.controllers;

import com.example.entity.user.UserDTO;
import com.example.entity.user.UserEntity;
import com.example.entity.user.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger("request-log");
    private final HttpServletRequest httpServletRequest;


    private final UserService userService;

    @Autowired
    public UserController(UserService userService, HttpServletRequest httpServletRequest) {
        this.userService = userService;
        this.httpServletRequest = httpServletRequest;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Long id) throws JsonProcessingException {
        UserEntity userEntity = userService.getEntityById(id);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        logger.info("BODY: " + ow.writeValueAsString(userEntity));
        return ResponseEntity.ok(userEntity);
    }

    @RequestMapping(value = "/users/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userService.getAllUsers();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        logger.info("BODY: ");
        users.forEach(userEntity -> {
            try {
                logger.info(ow.writeValueAsString(userEntity));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        return ResponseEntity.ok(users);
    }

    @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) throws JsonProcessingException {
        UserDTO newUserDTO = userService.createUser(userDTO);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        logger.info("BODY: " + ow.writeValueAsString(newUserDTO));
        return ResponseEntity.ok(newUserDTO);
    }

    @RequestMapping(value = "/users/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO, @PathVariable("id") Long id) throws JsonProcessingException {
        UserDTO newUserDTO = userService.createUser(userDTO);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        logger.info("BODY: " + ow.writeValueAsString(newUserDTO));
        return ResponseEntity.ok(userService.updateUser(newUserDTO, id));
    }
}
