package com.cityVibes.dto.projection;

import org.springframework.beans.factory.annotation.Value;

public interface CitySummary {
    Long getId();
    String getName();
    String getCountry();
}
