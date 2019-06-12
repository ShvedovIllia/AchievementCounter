package com.example.controllers;

import com.example.entity.activity.ActivityDTO;
import com.example.entity.activity.ActivityEntity;
import com.example.entity.activity.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActivityController {

    private static final Logger logger = LoggerFactory.getLogger("request-log");

    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @RequestMapping(value = "/activity/{id}", method = RequestMethod.GET)
    public ResponseEntity<ActivityEntity> getTeamById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(activityService.getEntityById(id));
    }

    @RequestMapping(value = "/activity/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<ActivityEntity>> getAllTeams() {
        return ResponseEntity.ok(activityService.getAllActivities());
    }

    @RequestMapping(value = "/activity/create", method = RequestMethod.POST)
    public ResponseEntity<?> createTeam(@RequestBody ActivityDTO activityDTO) {
        return ResponseEntity.ok(activityService.createActivity(activityDTO));
    }

    @RequestMapping(value = "/activity/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTeam(@RequestBody ActivityDTO activityDTO, @PathVariable("id") Long id) {
        return ResponseEntity.ok(activityService.updateActivity(activityDTO, id));
    }
}
