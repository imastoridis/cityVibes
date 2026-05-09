package com.cityVibes.feature.activity.dto.response;

public record ActivityResponseCultureRecord(
        Long id,
        String activity,
        Long rating,
        Long cityId,
        String theme
) implements ActivityResponse {
}