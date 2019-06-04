package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class AchievementCounterApplication {
    private static final Logger logger = LoggerFactory.getLogger(AchievementCounterApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AchievementCounterApplication.class, args);
        logger.info("---Application started!---");
    }
}
