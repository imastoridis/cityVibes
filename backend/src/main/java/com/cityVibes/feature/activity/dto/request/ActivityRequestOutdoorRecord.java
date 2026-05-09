package com.cityVibes.feature.activity.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ActivityRequestOutdoorRecord(
        @NotBlank String activity,
        @NotNull Long rating,
        @NotNull Long cityId,
        String difficulty
) implements ActivityRequest {
}