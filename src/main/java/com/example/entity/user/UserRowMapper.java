//package com.example.entity.user;
//
//
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class UserRowMapper implements RowMapper<UserEntity> {
//    @Override
//    public UserEntity mapRow(ResultSet resultSet, int i) throws SQLException {
//        UserEntity user = new UserEntity();
//        user.setId(resultSet.getLong("id"));
//        user.setName(resultSet.getString("name"));
//        user.setPassword(resultSet.getString("password"));
//        user.setDateOfCreation(resultSet.getDate("dateOfCreation").toLocalDate());
//        user.setTeamId(resultSet.getLong("teamId"));
//        return user;
//    }
//
//}
