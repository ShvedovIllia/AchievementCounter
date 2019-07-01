package com.example.entity.dummy;

import com.example.entity.team.TeamDTO;
import com.example.entity.team.TeamEntity;

public class TeamDummy {
    public static TeamEntity createUser(Long id, String name) {
        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setId(id);
        teamEntity.setName(name);
        return teamEntity;
    }

    public static TeamDTO createUserDTO(Long id, String name) {
        TeamDTO dto = new TeamDTO();
        dto.setId(id);
        dto.setName(name);
        return dto;
    }
}
