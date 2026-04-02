package com.cityVibes.dto.record;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public record VibeRecord(
        Long id,
        Boolean isPositive,
        String name
) implements Serializable {
}
