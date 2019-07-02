package com.example.entity.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceNew {
    @Autowired
    private UserEntity userEntity;

    public void doSomeThink() throws InterruptedException {

        while (true) {
            userEntity.init();
            Thread.sleep(700);
        }

    }
}
