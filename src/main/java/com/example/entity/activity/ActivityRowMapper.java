package com.example.entity.activity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActivityRowMapper implements RowMapper<ActivityEntity> {
    @Override
    public ActivityEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setId(resultSet.getLong("id"));
        activityEntity.setName(resultSet.getString("name"));
        return activityEntity;
    }
}
