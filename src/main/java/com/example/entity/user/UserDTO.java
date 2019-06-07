package com.example.entity.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter

public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private LocalDate dateOfCreation;
    private Long teamId;
}
