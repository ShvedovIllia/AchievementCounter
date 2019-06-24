package com.example.entity.Dummy;

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
}
