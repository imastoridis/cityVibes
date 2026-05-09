package com.cityVibes.feature.review.dto.response;

public record ReviewResponse(
        Long id,
        String review,
        Integer rating,
        Long userId,
        String username,
        Long cityId
) {}