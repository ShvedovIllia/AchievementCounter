package com.example.entity.user;

import com.example.constants.query.UserQueries;
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
public class UserServiceImpl {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public UserServiceImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public UserEntity getEntityById(Long id) {
        return jdbcTemplate.queryForObject(UserQueries.GET_USER_BY_ID_QUERY, new UserRowMapper(), id);
    }

    public List<UserEntity> getAllUsers() {
        return jdbcTemplate.query(UserQueries.GET_ALL_USERS_QUERY, new BeanPropertyRowMapper<>(UserEntity.class));
    }

    public UserDTO createUser(UserDTO userDTO) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource userParameters = new MapSqlParameterSource()
                .addValue("id", userDTO.getId())
                .addValue("name", userDTO.getName())
                .addValue("password", userDTO.getPassword())
                .addValue("dateOfCreation", LocalDate.now())
                .addValue("teamId", userDTO.getTeamId());
        namedParameterJdbcTemplate.update(
                UserQueries.ADD_USER_QUERY,
                userParameters,
                keyHolder);
        userDTO.setId(keyHolder.getKey().longValue());
        return userDTO;
    }

    public UserDTO updateUser(UserDTO userDTO, Long id) {

        userDTO.setId(id);
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", userDTO.getId())
                .addValue("name", userDTO.getName())
                .addValue("password", userDTO.getPassword())
                .addValue("teamId", userDTO.getTeamId());

        namedParameterJdbcTemplate.update(UserQueries.UPDATE_USER_QUERY, parameters);
        return userDTO;
    }
}