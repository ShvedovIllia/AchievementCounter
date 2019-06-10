package com.example.entity.team;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamRowMapper implements RowMapper<TeamEntity> {
    @Override
    public TeamEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setId(resultSet.getLong("id"));
        teamEntity.setName(resultSet.getString("name"));
        return teamEntity;
    }
}
