package com.example.controllers;

import com.example.entity.achievement.AchievementDTO;
import com.example.entity.achievement.AchievementEntity;
import com.example.entity.achievement.AchievementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AchievementController {

    private final AchievementServiceImpl achievementServiceImpl;

    @Autowired
    public AchievementController(AchievementServiceImpl achievementServiceImpl) {
        this.achievementServiceImpl = achievementServiceImpl;
    }

    @RequestMapping(value = "/achievements/{id}", method = RequestMethod.GET)
    public ResponseEntity<AchievementEntity> getAchievementById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(achievementServiceImpl.getById(id));
    }

    @RequestMapping(value = "/achievements/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<AchievementEntity>> getAllAchievements() {
        return ResponseEntity.ok(achievementServiceImpl.getAll());
    }

    @RequestMapping(value = "/achievements/create", method = RequestMethod.POST)
    public ResponseEntity<?> createAchievement(@RequestBody AchievementDTO achievementDTO) {
        return ResponseEntity.ok(achievementServiceImpl.create(achievementDTO));
    }

    @RequestMapping(value = "/achievements/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAchievement(@RequestBody AchievementDTO achievementDTO, @PathVariable("id") Long id) {
        return ResponseEntity.ok(achievementServiceImpl.update(achievementDTO, id));
    }
}
