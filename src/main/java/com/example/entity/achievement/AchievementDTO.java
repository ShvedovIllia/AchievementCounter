package com.example.entity.achievement;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AchievementDTO {

    private Long id;
    private String name;
    private String description;
    private LocalDate date_created;
    private LocalDate date_updated;
    private Integer points;
    private Long user_id;
}
