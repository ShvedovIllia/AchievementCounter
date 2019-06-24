package com.example.entity.dummy;

import com.example.entity.achievement.AchievementDTO;
import com.example.entity.achievement.AchievementEntity;

import java.time.LocalDate;

public class AchievementDummy {
    public static AchievementEntity createAchievement(Long id, String name, String desc, LocalDate dateOfCreation, LocalDate dateOfUpdate, int points, Long userId) {
        AchievementEntity achievementEntity = new AchievementEntity();
        achievementEntity.setId(id);
        achievementEntity.setName(name);
        achievementEntity.setDescription(desc);
        achievementEntity.setDate_created(dateOfCreation);
        achievementEntity.setDate_updated(dateOfUpdate);
        achievementEntity.setPoints(points);
        achievementEntity.setUser_id(userId);
        return achievementEntity;
    }

    public static AchievementDTO createAchievementDTO(Long id, String name, String desc, LocalDate dateOfCreation, LocalDate dateOfUpdate, int points, Long userId) {
        AchievementDTO achievementDTO = new AchievementDTO();
        achievementDTO.setId(id);
        achievementDTO.setName(name);
        achievementDTO.setDescription(desc);
        achievementDTO.setDate_created(dateOfCreation);
        achievementDTO.setDate_updated(dateOfUpdate);
        achievementDTO.setPoints(points);
        achievementDTO.setUser_id(userId);
        return achievementDTO;
    }
}
