package com.cityVibes.feature.review.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.Serializable;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public record ReviewRecord(
        Long id,
        String review,
        Integer rating
) implements Serializable {
}