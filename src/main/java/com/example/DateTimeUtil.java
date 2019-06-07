package com.example;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTimeUtil {

    public static LocalDate createLocalDate(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println(date);
        LocalDateTime localDateTime = LocalDateTime.parse(date, dateTimeFormatter);
        System.out.println(localDateTime);
        return null;
    }
}
