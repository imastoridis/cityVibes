package com.cityVibes.feature.activity.dto.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

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
        @JsonSubTypes.Type(value = ActivityRequestFoodRecord.class, name = "FOOD"),
        @JsonSubTypes.Type(value = ActivityRequestOutdoorRecord.class, name = "OUTDOOR"),
        @JsonSubTypes.Type(value = ActivityRequestCultureRecord.class, name = "CULTURE")
})
public sealed interface ActivityRequest permits ActivityRequestCultureRecord, ActivityRequestOutdoorRecord, ActivityRequestFoodRecord {
    String activity();

    Long rating();

    Long cityId();
}