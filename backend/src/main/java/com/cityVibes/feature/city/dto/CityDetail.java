package com.cityVibes.feature.city.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public record CityDetail(
        Long id,
        String name,
        String country
) implements Serializable {}