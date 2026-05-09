package com.cityVibes.feature.activity.dto.response;

public record ActivityResponseFoodRecord(
        Long id,
        String activity,
        Long rating,
        Long cityId,
        String cuisineType,
        Integer averagePrice
) implements ActivityResponse {
}