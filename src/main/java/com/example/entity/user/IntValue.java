package com.example.entity.user;

import com.example.annotations.RandomIntValue;

public class IntValue {
    @RandomIntValue(min = 5, max = 50, even = true)
    private Integer age;

    public IntValue() {

    }

    public Integer getAge() {
        return age;
    }
}
