package com.example.entity.activity;

import com.example.constants.query.ActivityQueries;
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
public class ActivityServiceImpl implements EntityService<ActivityEntity, ActivityDTO> {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ActivityServiceImpl(JdbcTemplate template, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = template;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public ActivityEntity getById(Long id) {
        return jdbcTemplate.queryForObject(ActivityQueries.GET_ACTIVITY_BY_ID_QUERY, new ActivityRowMapper(), id);
    }

    @Override
    public List<ActivityEntity> getAll() {
        return jdbcTemplate.query(ActivityQueries.GET_ALL_ACTIVITIES_QUERY, new BeanPropertyRowMapper<>(ActivityEntity.class));
    }

    @Override
    public ActivityDTO create(ActivityDTO dto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", dto.getId())
                .addValue("name", dto.getName());
        namedParameterJdbcTemplate.update(
                ActivityQueries.ADD_ACTIVITY_QUERY,
                parameters,
                keyHolder);
        dto.setId(keyHolder.getKey().longValue());
        return dto;
    }

    @Override
    public ActivityDTO update(ActivityDTO dto, Long id) {
        dto.setId(id);
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", dto.getId())
                .addValue("name", dto.getName());
        namedParameterJdbcTemplate.update(ActivityQueries.UPDATE_ACTIVITY_QUERY, parameters);
        return dto;
    }
}
