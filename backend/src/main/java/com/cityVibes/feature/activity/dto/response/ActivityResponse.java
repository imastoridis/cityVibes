package com.cityVibes.feature.activity.dto.response;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Activity interface for responses
 * There are different activities (Food, outdoor, culture..)
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type" // Le champ JSON qui dira "FOOD", "OUTDOOR", etc.
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ActivityResponse.Food.class, name = "FOOD"),
        @JsonSubTypes.Type(value = ActivityResponse.Outdoor.class, name = "OUTDOOR"),
        @JsonSubTypes.Type(value = ActivityResponse.Culture.class, name = "CULTURE")
})
public sealed interface ActivityResponse permits ActivityResponse.Culture, ActivityResponse.Food, ActivityResponse.Outdoor {
    Long id();

    String activity();

    Long cityId();

    /* Records for each activity type*/
    record Food(Long id, String activity, Long cityId, String cuisineType,
                Integer averagePrice) implements ActivityResponse {
    }

    record Outdoor(Long id, String activity, Long cityId, String difficulty) implements ActivityResponse {
    }

    record Culture(Long id, String activity, Long cityId, String theme) implements ActivityResponse {
    }
}