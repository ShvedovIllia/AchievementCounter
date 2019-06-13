package com.example.controllers;

import com.example.entity.team.TeamDTO;
import com.example.entity.team.TeamEntity;
import com.example.entity.team.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    private final TeamServiceImpl teamServiceImpl;

    @Autowired
    public TeamController(TeamServiceImpl teamServiceImpl) {
        this.teamServiceImpl = teamServiceImpl;
    }

    @RequestMapping(value = "/teams/{id}", method = RequestMethod.GET)
    public ResponseEntity<TeamEntity> getTeamById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(teamServiceImpl.getById(id));
    }

    @RequestMapping(value = "/teams/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<TeamEntity>> getAllTeams() {
        return ResponseEntity.ok(teamServiceImpl.getAll());
    }

    @RequestMapping(value = "/teams/create", method = RequestMethod.POST)
    public ResponseEntity<?> createTeam(@RequestBody TeamDTO teamDTO) {
        return ResponseEntity.ok(teamServiceImpl.create(teamDTO));
    }

    @RequestMapping(value = "/teams/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTeam(@RequestBody TeamDTO teamDTO, @PathVariable("id") Long id) {
        return ResponseEntity.ok(teamServiceImpl.update(teamDTO, id));
    }
}
