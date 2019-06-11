package com.example.config;

import com.example.utils.UsersRequestIncreptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfigurer implements WebMvcConfigurer {

    private final UsersRequestIncreptor usersRequestIncreptor;

    @Autowired
    public MVCConfigurer(UsersRequestIncreptor usersRequestIncreptor) {
        this.usersRequestIncreptor = usersRequestIncreptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(usersRequestIncreptor)
                .addPathPatterns("/**/users/**/")
                .addPathPatterns("/**/teams/**/")
                .addPathPatterns("/**/achievements/**/")
                .addPathPatterns("/**/activity/**/");

    }
}