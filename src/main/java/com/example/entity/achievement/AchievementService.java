package com.example.entity.achievement;

import com.example.constants.query.AchievementQueries;
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
public class AchievementService {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public AchievementService(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public AchievementEntity getEntityById(Long id) {
        return jdbcTemplate.queryForObject(AchievementQueries.GET_ACHIEVEMENT_BY_ID_QUERY, new AchievementRowMapper(), id);
    }

    public List<AchievementEntity> getAllAchievements() {
        return jdbcTemplate.query(AchievementQueries.GET_ALL_ACHIEVEMENTS_QUERY, new BeanPropertyRowMapper<>(AchievementEntity.class));
    }

    public AchievementDTO createAchievement(AchievementDTO achievementDTO) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", achievementDTO.getId())
                .addValue("name", achievementDTO.getName())
                .addValue("description", achievementDTO.getDescription())
                .addValue("date_created", achievementDTO.getDate_created())
                .addValue("date_updated", achievementDTO.getDate_updated())
                .addValue("points", achievementDTO.getPoints())
                .addValue("user_id", achievementDTO.getUser_id());
        namedParameterJdbcTemplate.update(
                AchievementQueries.ADD_ACHIEVEMENT_QUERY,
                parameters,
                keyHolder);
        achievementDTO.setId(keyHolder.getKey().longValue());
        return achievementDTO;
    }

    public AchievementDTO updateAchievement(AchievementDTO achievementDTO, Long id) {

        achievementDTO.setId(id);
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", achievementDTO.getId())
                .addValue("name", achievementDTO.getName())
                .addValue("description", achievementDTO.getDescription())
                .addValue("date_created", LocalDate.now())
                .addValue("date_updated", LocalDate.now())
                .addValue("points", achievementDTO.getPoints())
                .addValue("user_id", achievementDTO.getUser_id());

        namedParameterJdbcTemplate.update(AchievementQueries.UPDATE_ACHIEVEMENT_QUERY, parameters);
        return achievementDTO;
    }
}
