package com.example.entity.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserEntity {

    @Id
    private Long id;
    private String username;
    private String password;
    private LocalDate dateOfCreation;
    private Long teamId;
}
