package com.example.entity;

import com.example.entity.Dummy.AchievementDummy;
import com.example.entity.achievement.AchievementEntity;
import com.example.entity.achievement.AchievementRowMapper;
import com.example.entity.achievement.AchievementServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AchievementServiceImplTest {

    @Autowired
    private AchievementServiceImpl achievementService;

    @MockBean
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() throws Exception {
        AchievementEntity entity = AchievementDummy.createAchievement(1L, "testName", "desc", LocalDate.now(), LocalDate.now(), 5, 1L);
        Mockito.when(jdbcTemplate.queryForObject(anyString(), any(AchievementRowMapper.class), anyLong())).thenReturn(entity);
    }

    @Test
    public void getByIdAssertingByNameTest() {
        AchievementEntity entity1 = achievementService.getById(1L);
        Assert.assertEquals("testName", entity1.getName());
    }
}
