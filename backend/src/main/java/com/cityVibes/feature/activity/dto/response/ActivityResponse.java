package com.cityVibes.feature.activity.dto.response;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Activity interface for responses
 * There are different activities (Food, outdoor, culture...)
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type" // Le champ JSON qui dira "FOOD", "OUTDOOR", etc.
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ActivityResponseFoodRecord.class, name = "FOOD"),
        @JsonSubTypes.Type(value = ActivityResponseOutdoorRecord.class, name = "OUTDOOR"),
        @JsonSubTypes.Type(value = ActivityResponseCultureRecord.class, name = "CULTURE")
})
public sealed interface ActivityResponse permits ActivityResponseCultureRecord, ActivityResponseFoodRecord, ActivityResponseOutdoorRecord {
    Long id();

    String activity();

    Long rating();

    Long cityId();
}