package com.example;

import com.example.entity.user.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class AchievementCounterApplication {
    private static final Logger logger = LoggerFactory.getLogger(AchievementCounterApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AchievementCounterApplication.class, args);
        logger.info("---Application started!---");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        context.getBean(UserEntity.class).testMethod();
    }
}
