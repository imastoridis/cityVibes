package com.cityVibes.feature.city.dto.response;

import com.cityVibes.feature.activity.dto.response.ActivityResponseCultureRecord;
import com.cityVibes.feature.activity.dto.response.ActivityResponseFoodRecord;
import com.cityVibes.feature.activity.dto.response.ActivityResponseOutdoorRecord;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

/**
 * Activity interface for responses
 * There are different activities (Food, outdoor, culture...)
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public record CityResponseRecord(
        Long id,
        String name,
        String country
) implements Serializable {
}

