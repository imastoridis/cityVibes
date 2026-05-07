package com.cityVibes.feature.activity.mapper;

import com.cityVibes.feature.activity.dto.response.ActivityResponse;
import com.cityVibes.feature.activity.entity.CultureActivity;
import com.cityVibes.feature.activity.entity.FoodActivity;
import com.cityVibes.feature.activity.entity.OutdoorActivity;
import com.cityVibes.feature.city.entity.City;
import com.cityVibes.feature.activity.entity.Activity;

public class ActivityMapper {

    /**
     * Maps Activity entity to ActivityResponse DTO
     * @param activity - Activity entity
     * @return ActivityResponse
     */
    public static ActivityResponse toResponse(Activity activity) {
        return switch (activity) {
            case FoodActivity f -> new ActivityResponse.Food(
                    f.getId(),
                    f.getActivity(),
                    f.getCity().getId(),
                    f.getCuisineType(),
                    f.getAveragePrice()
            );

            case OutdoorActivity o -> new ActivityResponse.Outdoor(
                    o.getId(),
                    o.getActivity(),
                    o.getCity().getId(),
                    o.getDifficulty()
            );

            case CultureActivity c -> new ActivityResponse.Culture(
                    c.getId(),
                    c.getActivity(),
                    c.getCity().getId(),
                    c.getTheme()
            );

            default -> throw new IllegalArgumentException("Type d'activité non supportée : " + activity.getClass());
        };
    }

    // Convert Response to Entity // TO DO OR DELETE
/*    public static Activity toEntity(ActivityDto activityDto, City city) {

        if (activityDto == null) return null;

        Activity activity = new Activity();
        activity.setActivity(activityDto.getActivity());
        activity.setCity(city);
        return activity;
    }*/
}
