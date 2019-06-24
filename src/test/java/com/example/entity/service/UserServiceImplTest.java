package com.example.entity.service;

import com.example.entity.dummy.UserDummy;
import com.example.entity.user.UserDTO;
import com.example.entity.user.UserEntity;
import com.example.entity.user.UserRowMapper;
import com.example.entity.user.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @MockBean
    private JdbcTemplate jdbcTemplate;

    @MockBean
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Before
    public void setUp() throws Exception {
        UserEntity entity = UserDummy.createUser(1L, "testName", "password", LocalDate.now(), 1L);
        Mockito.when(jdbcTemplate.queryForObject(anyString(), any(UserRowMapper.class), anyLong())).thenReturn(entity);
        List<UserEntity> entities = new ArrayList<>();

        entities.add(entity);
        entities.add(new UserEntity());
        Mockito.when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(entities);
        Mockito.when(namedParameterJdbcTemplate.update(anyString(), any(MapSqlParameterSource.class), any(GeneratedKeyHolder.class))).thenReturn(1);
        Mockito.when(namedParameterJdbcTemplate.update(anyString(), any(MapSqlParameterSource.class))).thenReturn(1);
    }

    @Test
    public void getByIdAssertingByNameTest() {
        UserEntity entity = userService.getById(1L);
        Assert.assertEquals("testName", entity.getName());
    }

    @Test
    public void getAllAchievementsTest() {
        List<UserEntity> entities = userService.getAll();
        Assert.assertEquals(2, entities.size());
    }

//    @Test
//    public void createAchievementTest() {
//        AchievementDTO dto = AchievementDummy.createAchievementDTO(1L, "testName", "desc", LocalDate.now(), LocalDate.now(), 5, 3L);
//        AchievementDTO achievementDTO = achievementService.create(dto);
//        Assert.assertEquals(1, achievementDTO.getId().intValue());
//    }


    @Test
    public void updateAchievementTest() {
        UserDTO dto = UserDummy.createUserDTO(1L, "testName", "password", LocalDate.now(), 1L);
        UserDTO achievementDTO = userService.update(dto, 1L);
        Assert.assertEquals(dto.getName(), achievementDTO.getName());
    }
}
