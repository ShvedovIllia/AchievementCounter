package com.example.controllers;

import com.example.entity.activity.ActivityDTO;
import com.example.entity.activity.ActivityEntity;
import com.example.entity.activity.ActivityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActivityController {


    private final ActivityServiceImpl activityServiceImpl;

    @Autowired
    public ActivityController(ActivityServiceImpl activityServiceImpl) {
        this.activityServiceImpl = activityServiceImpl;
    }

    @RequestMapping(value = "/activity/{id}", method = RequestMethod.GET)
    public ResponseEntity<ActivityEntity> getTeamById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(activityServiceImpl.getById(id));
    }

    @RequestMapping(value = "/activity/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<ActivityEntity>> getAllTeams() {
        return ResponseEntity.ok(activityServiceImpl.getAll());
    }

    @RequestMapping(value = "/activity/create", method = RequestMethod.POST)
    public ResponseEntity<?> createTeam(@RequestBody ActivityDTO activityDTO) {
        return ResponseEntity.ok(activityServiceImpl.create(activityDTO));
    }

    @RequestMapping(value = "/activity/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTeam(@RequestBody ActivityDTO activityDTO, @PathVariable("id") Long id) {
        return ResponseEntity.ok(activityServiceImpl.update(activityDTO, id));
    }
}
