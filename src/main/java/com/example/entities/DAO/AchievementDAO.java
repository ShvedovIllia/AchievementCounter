package com.example.entities.DAO;

import lombok.Data;

@Data
public class AchievementDAO {

    private String title;
    private String description;
    private String dateCreated;
    private String dateUpdated;
    private Integer points;
    private Long userId;
}
