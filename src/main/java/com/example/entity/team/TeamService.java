package com.example.entity.team;

import com.example.constants.query.TeamQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public TeamService(JdbcTemplate template, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = template;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public TeamEntity getEntityById(Long id) {
        return jdbcTemplate.queryForObject(TeamQueries.GET_TEAM_BY_ID_QUERY, new TeamRowMapper(), id);
    }

    public List<TeamEntity> getAllTeams() {
        return jdbcTemplate.query(TeamQueries.GET_ALL_TEAMS_QUERY, new BeanPropertyRowMapper<>(TeamEntity.class));
    }

    public TeamDTO createTeam(TeamDTO teamDTO) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", teamDTO.getId())
                .addValue("name", teamDTO.getName());
        namedParameterJdbcTemplate.update(
                TeamQueries.ADD_TEAM_QUERY,
                parameters,
                keyHolder);
        teamDTO.setId(keyHolder.getKey().longValue());
        return teamDTO;
    }

    public TeamDTO updateTeam(TeamDTO teamDTO, Long id) {
        teamDTO.setId(id);
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", teamDTO.getId())
                .addValue("name", teamDTO.getName());
        namedParameterJdbcTemplate.update(TeamQueries.UPDATE_TEAM_QUERY, parameters);
        return teamDTO;
    }
}