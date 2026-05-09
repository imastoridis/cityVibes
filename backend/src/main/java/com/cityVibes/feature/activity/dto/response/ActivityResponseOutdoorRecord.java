package com.cityVibes.feature.activity.dto.response;

public record ActivityResponseOutdoorRecord(
        Long id,
        String activity,
        Long rating,
        Long cityId,
        String difficulty
) implements ActivityResponse {
}
