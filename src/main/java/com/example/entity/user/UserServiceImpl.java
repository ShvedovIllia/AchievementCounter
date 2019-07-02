package com.example.entity.user;

import com.example.constants.query.UserQueries;
import com.example.entity.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements EntityService<UserEntity, UserDTO> {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public UserServiceImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public UserEntity getById(Long id) {
        return jdbcTemplate.queryForObject(UserQueries.GET_USER_BY_ID_QUERY, new SingleColumnRowMapper<>(), id);
    }

    @Override
    public List<UserEntity> getAll() {
        return jdbcTemplate.query(UserQueries.GET_ALL_USERS_QUERY, new BeanPropertyRowMapper<>(UserEntity.class));
    }

    @Override
    public UserDTO create(UserDTO dto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource userParameters = new MapSqlParameterSource()
                .addValue("id", dto.getId())
                .addValue("name", dto.getName())
                .addValue("password", dto.getPassword())
                .addValue("dateOfCreation", LocalDate.now())
                .addValue("teamId", dto.getTeamId());
        namedParameterJdbcTemplate.update(
                UserQueries.ADD_USER_QUERY,
                userParameters,
                keyHolder);
        dto.setId(keyHolder.getKey().longValue());
        return dto;
    }

    @Override
    public UserDTO update(UserDTO dto, Long id) {
        dto.setId(id);
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", dto.getId())
                .addValue("name", dto.getName())
                .addValue("password", dto.getPassword())
                .addValue("teamId", dto.getTeamId());

        namedParameterJdbcTemplate.update(UserQueries.UPDATE_USER_QUERY, parameters);
        return dto;
    }
}