package com.example.entity.user;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RandomValueIllia {
    int min();

    int max();
}
