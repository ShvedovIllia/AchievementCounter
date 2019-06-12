package com.example.controllers;

import com.example.entity.team.TeamDTO;
import com.example.entity.team.TeamEntity;
import com.example.entity.team.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    private static final Logger logger = LoggerFactory.getLogger("request-log");

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @RequestMapping(value = "/teams/{id}", method = RequestMethod.GET)
    public ResponseEntity<TeamEntity> getTeamById(@PathVariable("id") Long id) {
        logger.info("Request to get team with id = " + id);
        TeamEntity teamEntity = teamService.getEntityById(id);
        logger.info("Team with id " + id + "! \nName: " + teamEntity.getName());
        return ResponseEntity.ok(teamEntity);
    }

    @RequestMapping(value = "/teams/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<TeamEntity>> getAllTeams() {
        logger.info("Request to get all teams");
        List<TeamEntity> teams = teamService.getAllTeams();
        logger.info(teams.size() + " teams found!");
        return ResponseEntity.ok(teams);
    }

    @RequestMapping(value = "/teams/create", method = RequestMethod.POST)
    public ResponseEntity<?> createTeam(@RequestBody TeamDTO teamDTO) {
        TeamDTO teamDTOnew = teamService.createTeam(teamDTO);
        logger.info("Team created with id " + teamDTOnew.getId() + " and name '" + teamDTOnew.getName() + "'!");
        return ResponseEntity.ok(teamDTOnew);
    }

    @RequestMapping(value = "/teams/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTeam(@RequestBody TeamDTO teamDTO, @PathVariable("id") Long id) {
        logger.info("Request to update team with id = " + id);
        return ResponseEntity.ok(teamService.updateTeam(teamDTO, id));
    }
}
