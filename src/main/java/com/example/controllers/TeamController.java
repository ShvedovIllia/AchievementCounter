package com.example.controllers;

import com.example.entity.team.TeamDTO;
import com.example.entity.team.TeamEntity;
import com.example.entity.team.TeamService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger("request-log");

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @RequestMapping(value = "/teams/{id}", method = RequestMethod.GET)
    public ResponseEntity<TeamEntity> getTeamById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(teamService.getEntityById(id));
    }

    @RequestMapping(value = "/teams/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<TeamEntity>> getAllTeams() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }

    @RequestMapping(value = "/teams/create", method = RequestMethod.POST)
    public ResponseEntity<?> createTeam(@RequestBody TeamDTO teamDTO) {
        return ResponseEntity.ok(teamService.createTeam(teamDTO));
    }

    @RequestMapping(value = "/teams/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTeam(@RequestBody TeamDTO teamDTO, @PathVariable("id") Long id) {
        return ResponseEntity.ok(teamService.updateTeam(teamDTO, id));
    }
}
