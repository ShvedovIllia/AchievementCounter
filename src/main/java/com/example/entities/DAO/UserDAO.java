package com.example.entities.DAO;

import lombok.Data;

@Data
public class UserDAO {

    private String name;
    private String password;
    private String dateOfCreation;
    private Long teamId;
}
