package com.example.entity.dummy;

import com.example.entity.user.UserDTO;
import com.example.entity.user.UserEntity;

import java.time.LocalDate;

public class UserDummy {

    public static UserEntity createUser(Long id, String name, String password, LocalDate dateOfCreation, Long teamId) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setName(name);
        userEntity.setPassword(password);
        userEntity.setDateOfCreation(dateOfCreation);
        userEntity.setTeamId(teamId);
        return userEntity;
    }

    public static UserDTO createUserDTO(Long id, String name, String password, LocalDate dateOfCreation, Long teamId) {
        UserDTO userEntity = new UserDTO();
        userEntity.setId(id);
        userEntity.setName(name);
        userEntity.setPassword(password);
        userEntity.setDateOfCreation(dateOfCreation);
        userEntity.setTeamId(teamId);
        return userEntity;
    }
}
