package com.cityVibes.mapper;

import com.cityVibes.dto.ActivityDto;
import com.cityVibes.model.entity.City;
import com.cityVibes.model.entity.Activity;

public class ActivityMapper {

    // Convert Entity to DTO
    public static ActivityDto toDto(Activity activity) {
        if (activity == null) return null;

        ActivityDto dto = new ActivityDto();
        dto.setId(activity.getId());
        dto.setActivity(activity.getActivity());
        dto.setCityId(activity.getCity().getId());
        return dto;
    }

    // Convert DTO to Entity
    public static Activity toEntity(ActivityDto activityDto, City city) {

        if (activityDto == null) return null;

        Activity activity = new Activity();
        activity.setActivity(activityDto.getActivity());
        activity.setCity(city);
        return activity;
    }
}
