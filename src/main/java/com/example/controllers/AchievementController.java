package com.example.controllers;

import com.example.entity.achievement.AchievementDTO;
import com.example.entity.achievement.AchievementEntity;
import com.example.entity.achievement.AchievementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AchievementController {

    private static final Logger logger = LoggerFactory.getLogger("request-log");

    private final AchievementService achievementService;

    @Autowired
    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @RequestMapping(value = "/achievements/{id}", method = RequestMethod.GET)
    public ResponseEntity<AchievementEntity> getAchievementById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(achievementService.getEntityById(id));
    }

    @RequestMapping(value = "/achievements/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<AchievementEntity>> getAllAchievements() {
        return ResponseEntity.ok(achievementService.getAllAchievements());
    }

    @RequestMapping(value = "/achievements/create", method = RequestMethod.POST)
    public ResponseEntity<?> createAchievement(@RequestBody AchievementDTO achievementDTO) {
        return ResponseEntity.ok(achievementService.createAchievement(achievementDTO));
    }

    @RequestMapping(value = "/achievements/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAchievement(@RequestBody AchievementDTO achievementDTO, @PathVariable("id") Long id) {
        return ResponseEntity.ok(achievementService.updateAchievement(achievementDTO, id));
    }
}
