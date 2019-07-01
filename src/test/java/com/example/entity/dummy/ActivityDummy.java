package com.example.entity.dummy;

import com.example.entity.activity.ActivityDTO;
import com.example.entity.activity.ActivityEntity;

public class ActivityDummy {

    public static ActivityEntity createActivity(Long id, String name) {
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setId(id);
        activityEntity.setName(name);
        return activityEntity;
    }

    public static ActivityDTO createActivityDTO(Long id, String name) {
        ActivityDTO dto = new ActivityDTO();
        dto.setId(id);
        dto.setName(name);
        return dto;
    }
}
