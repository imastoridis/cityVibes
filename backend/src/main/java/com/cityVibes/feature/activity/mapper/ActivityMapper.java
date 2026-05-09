package com.cityVibes.feature.activity.mapper;

import com.cityVibes.feature.activity.dto.response.ActivityResponse;
import com.cityVibes.feature.activity.dto.response.ActivityResponseCultureRecord;
import com.cityVibes.feature.activity.dto.response.ActivityResponseFoodRecord;
import com.cityVibes.feature.activity.dto.response.ActivityResponseOutdoorRecord;
import com.cityVibes.feature.activity.entity.CultureActivity;
import com.cityVibes.feature.activity.entity.FoodActivity;
import com.cityVibes.feature.activity.entity.OutdoorActivity;
import com.cityVibes.feature.activity.entity.Activity;

public class ActivityMapper {

    /**
     * Maps Activity entity to ActivityResponse DTO
     *
     * @param activity - Activity entity
     * @return ActivityResponse
     */
    public static ActivityResponse toResponse(Activity activity) {
        return switch (activity) {
            case FoodActivity f -> new ActivityResponseFoodRecord(
                    f.getId(),
                    f.getActivity(),
                    f.getRating(),
                    f.getCity().getId(),
                    f.getCuisineType(),
                    f.getAveragePrice()
            );

            case OutdoorActivity o -> new ActivityResponseOutdoorRecord(
                    o.getId(),
                    o.getActivity(),
                    o.getRating(),
                    o.getCity().getId(),
                    o.getDifficulty()
            );

            case CultureActivity c -> new ActivityResponseCultureRecord(
                    c.getId(),
                    c.getActivity(),
                    c.getRating(),
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
