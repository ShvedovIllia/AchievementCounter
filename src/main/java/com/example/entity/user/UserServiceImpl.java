package com.example.entity.user;

import com.example.constants.query.UserQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UserEntity getEntityById(Long id) {
        return jdbcTemplate.queryForObject(UserQueries.GET_USER_BY_ID_QUERY, new UserRowMapper(), id);
    }

    public List<UserEntity> getAllUsers() {
        List<UserEntity> userEntities = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(UserQueries.GET_ALL_USERS_QUERY);
        rows.forEach(row -> {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(Long.parseLong(row.get("id").toString()));
            userEntity.setUsername((String) (row.get("name")));
            userEntity.setPassword((String) (row.get("password")));
            Timestamp date = (Timestamp) (row.get("dateOfCreation"));
            userEntity.setDateOfCreation(date.toLocalDateTime().toLocalDate());
            userEntity.setTeamId(Long.parseLong(row.get("teamId").toString()));
            userEntities.add(userEntity);
        });
        return userEntities;
    }

    public UserEntity createUser(UserDTO userDTO) {
        SqlParameterSource userParameters = new MapSqlParameterSource()
                .addValue("id", userDTO.getId())
                .addValue("name", userDTO.getUsername())
                .addValue("password", userDTO.getPassword())
                .addValue("dateOfCreation", userDTO.getDateOfCreation())
                .addValue("teamId", userDTO.getTeamId());
        return jdbcTemplate.queryForObject(
                UserQueries.ADD_USER_QUERY,
                new SqlParameterSource[]{userParameters},
                new UserRowMapper());
    }

    public UserEntity updateUser(UserDTO userDTO, Long id) {
        return null;
    }
}
