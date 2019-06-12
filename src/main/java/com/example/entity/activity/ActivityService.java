package com.example.entity.activity;

import com.example.constants.query.ActivityQueries;
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
public class ActivityService {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ActivityService(JdbcTemplate template, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = template;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public ActivityEntity getEntityById(Long id) {
        return jdbcTemplate.queryForObject(ActivityQueries.GET_ACTIVITY_BY_ID_QUERY, new ActivityRowMapper(), id);
    }

    public List<ActivityEntity> getAllActivities() {
        return jdbcTemplate.query(ActivityQueries.GET_ALL_ACTIVITIES_QUERY, new BeanPropertyRowMapper<>(ActivityEntity.class));
    }

    public ActivityDTO createActivity(ActivityDTO activityDTO) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", activityDTO.getId())
                .addValue("name", activityDTO.getName());
        namedParameterJdbcTemplate.update(
                ActivityQueries.ADD_ACTIVITY_QUERY,
                parameters,
                keyHolder);
        activityDTO.setId(keyHolder.getKey().longValue());
        return activityDTO;
    }

    public ActivityDTO updateActivity(ActivityDTO activityDTO, Long id) {
        activityDTO.setId(id);
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", activityDTO.getId())
                .addValue("name", activityDTO.getName());
        namedParameterJdbcTemplate.update(ActivityQueries.UPDATE_ACTIVITY_QUERY, parameters);
        return activityDTO;
    }
}
