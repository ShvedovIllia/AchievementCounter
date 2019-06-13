package com.example.entity.achievement;

import com.example.constants.query.AchievementQueries;
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

import java.time.LocalDate;
import java.util.List;

@Service
public class AchievementServiceImpl implements EntityService<AchievementEntity, AchievementDTO> {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public AchievementServiceImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public AchievementEntity getById(Long id) {
        return jdbcTemplate.queryForObject(AchievementQueries.GET_ACHIEVEMENT_BY_ID_QUERY, new AchievementRowMapper(), id);
    }

    @Override
    public List<AchievementEntity> getAll() {
        return jdbcTemplate.query(AchievementQueries.GET_ALL_ACHIEVEMENTS_QUERY, new BeanPropertyRowMapper<>(AchievementEntity.class));
    }

    @Override
    public AchievementDTO create(AchievementDTO dto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", dto.getId())
                .addValue("name", dto.getName())
                .addValue("description", dto.getDescription())
                .addValue("date_created", dto.getDate_created())
                .addValue("date_updated", dto.getDate_updated())
                .addValue("points", dto.getPoints())
                .addValue("user_id", dto.getUser_id());
        namedParameterJdbcTemplate.update(
                AchievementQueries.ADD_ACHIEVEMENT_QUERY,
                parameters,
                keyHolder);
        dto.setId(keyHolder.getKey().longValue());
        return dto;
    }

    @Override
    public AchievementDTO update(AchievementDTO dto, Long id) {
        dto.setId(id);
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", dto.getId())
                .addValue("name", dto.getName())
                .addValue("description", dto.getDescription())
                .addValue("date_created", LocalDate.now())
                .addValue("date_updated", LocalDate.now())
                .addValue("points", dto.getPoints())
                .addValue("user_id", dto.getUser_id());

        namedParameterJdbcTemplate.update(AchievementQueries.UPDATE_ACHIEVEMENT_QUERY, parameters);
        return dto;
    }
}
