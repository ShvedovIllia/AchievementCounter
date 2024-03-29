package com.example;

import com.example.entity.user.UserEntity;
import com.example.entity.user.UserServiceNew;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AchievementCounterApplication {
    private static final Logger logger = LoggerFactory.getLogger(AchievementCounterApplication.class);

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext run = SpringApplication.run(AchievementCounterApplication.class, args);
        logger.info("---Application started!---");
        run.getBean(UserServiceNew.class).doSomeThink();
    }
}
