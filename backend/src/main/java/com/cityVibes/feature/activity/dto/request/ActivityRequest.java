package com.cityVibes.feature.activity.dto.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Activity interface for requests
 *
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ActivityRequest.Food.class, name = "FOOD"),
        @JsonSubTypes.Type(value = ActivityRequest.Outdoor.class, name = "OUTDOOR"),
        @JsonSubTypes.Type(value = ActivityRequest.Culture.class, name = "CULTURE")
})
public sealed interface ActivityRequest {
    String activity();

    Long cityId();

    /* Records for each activity type*/
    record Food(
            @NotBlank String activity,
            @NotNull Long cityId,
            String cuisineType,
            Integer averagePrice
    ) implements ActivityRequest {
    }

    record Outdoor(
            @NotBlank String activity,
            @NotNull Long cityId,
            String difficulty
    ) implements ActivityRequest {
    }

    record Culture(
            @NotBlank String activity,
            @NotNull Long cityId,
            String theme
    ) implements ActivityRequest {
    }
}