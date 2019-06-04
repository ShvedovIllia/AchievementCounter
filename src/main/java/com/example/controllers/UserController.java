package com.example.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "/")
    public ResponseEntity createUser () {
        return ResponseEntity.ok().build();
    }
}
