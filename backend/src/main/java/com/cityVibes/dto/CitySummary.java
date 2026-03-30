package com.cityVibes.dto;

import org.springframework.beans.factory.annotation.Value;

public interface CitySummary {
    Long getId();
    String getName();
    String getCountry();

    @Value("#{target.getName + ' ' + target.getCountry}")
    String getFullName();
}
