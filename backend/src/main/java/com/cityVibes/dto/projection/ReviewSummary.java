package com.cityVibes.dto.projection;

import org.springframework.beans.factory.annotation.Value;

public interface ReviewSummary {
    Long getId();
    String getReview();
    Integer getRating();
   // Long getCityId();
    //Long getUserId();

    @Value("#{target.city.name}")
    String getCityName();
}
