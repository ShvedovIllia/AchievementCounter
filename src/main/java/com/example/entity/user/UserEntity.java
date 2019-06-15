package com.example.entity.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor

public class UserEntity {

    @Id
    private Long id;
    private String name;
    private String password;
    private LocalDate dateOfCreation;
    private Long teamId;

    private String testField;
    @RandomValueIllia(min = 2, max = 9)
    private int someRandom;

    public UserEntity() {
        System.out.println("Constructor");
    }

    public void testMethod() {
        for (int i = 0; i < someRandom; i++) {
            System.out.println(testField);
        }
    }

    @PostConstruct
    public void init() {
        System.out.println("init method");
    }
}
