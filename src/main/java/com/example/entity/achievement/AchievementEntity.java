package com.example.entity.achievement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AchievementEntity {

    @Id
    private Long id;
    private String name;
    private String description;
    private LocalDate date_created;
    private LocalDate date_updated;
    private Integer points;
    private Long user_id;
}
