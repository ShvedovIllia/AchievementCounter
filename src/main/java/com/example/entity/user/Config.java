package com.example.entity.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

    @Bean
    @Scope("interval")
    public IntValue intValue() {
        return new IntValue();
    }

    @Bean
    public UserEntity userEntity() {
        return new UserEntity() {
            @Override
            protected IntValue setNewAge() {
                return intValue();
            }
        };
    }

}
