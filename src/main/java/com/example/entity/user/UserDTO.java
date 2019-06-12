package com.example.entity.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter

public class UserDTO {

    private Long id;
    private String name;
    private String password;
    private LocalDate dateOfCreation;
    private Long teamId;

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                ", teamId=" + teamId +
                '}';
    }
}
