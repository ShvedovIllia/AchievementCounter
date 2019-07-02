package com.example.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RandomIntValue {
    int min();

    int max();

    boolean odd() default false;//true - 1, 3, 5...

    boolean even() default false;//true - 2, 4, 6...
}
