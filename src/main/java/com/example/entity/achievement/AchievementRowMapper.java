package com.example.entity.achievement;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AchievementRowMapper implements RowMapper<AchievementEntity> {
    @Override
    public AchievementEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        AchievementEntity achievementEntity = new AchievementEntity();
        achievementEntity.setId(resultSet.getLong("id"));
        achievementEntity.setName(resultSet.getString("name"));
        achievementEntity.setDescription(resultSet.getString("description"));
        achievementEntity.setDate_created(resultSet.getDate("date_created").toLocalDate());
        achievementEntity.setDate_updated(resultSet.getDate("date_updated").toLocalDate());
        achievementEntity.setPoints(resultSet.getInt("points"));
        achievementEntity.setUser_id(resultSet.getLong("user_id"));
        return achievementEntity;
    }
}
