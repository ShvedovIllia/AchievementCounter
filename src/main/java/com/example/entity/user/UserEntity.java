package com.example.entity.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Getter
@Setter

public abstract class UserEntity {

    @Id
    private Long id;
    private String name;
    private String password;
    private LocalDate dateOfCreation;
    private Long teamId;
    //    @RandomIntValue(max = 20, min = 4)
    private Integer age;

    public UserEntity() {
        System.out.println("constructor");
    }

    protected abstract IntValue setNewAge();

    public void init() throws InterruptedException {
        age = setNewAge().getAge();
        System.out.println("age = " + age);
        Thread.sleep(1000);
    }
}
