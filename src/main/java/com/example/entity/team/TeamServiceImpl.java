package com.example.entity.team;

import com.example.constants.query.TeamQueries;
import com.example.entity.EntityService;
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
public class TeamServiceImpl implements EntityService<TeamEntity, TeamDTO> {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public TeamServiceImpl(JdbcTemplate template, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = template;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public TeamEntity getById(Long id) {
        return jdbcTemplate.queryForObject(TeamQueries.GET_TEAM_BY_ID_QUERY, new TeamRowMapper(), id);
    }

    @Override
    public List<TeamEntity> getAll() {
        return jdbcTemplate.query(TeamQueries.GET_ALL_TEAMS_QUERY, new BeanPropertyRowMapper<>(TeamEntity.class));
    }

    @Override
    public TeamDTO create(TeamDTO dto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", dto.getId())
                .addValue("name", dto.getName());
        namedParameterJdbcTemplate.update(
                TeamQueries.ADD_TEAM_QUERY, parameters, keyHolder);
        dto.setId(keyHolder.getKey().longValue());
        return dto;
    }

    @Override
    public TeamDTO update(TeamDTO dto, Long id) {
        dto.setId(id);
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", dto.getId())
                .addValue("name", dto.getName());
        namedParameterJdbcTemplate.update(TeamQueries.UPDATE_TEAM_QUERY, parameters);
        return dto;
    }
}