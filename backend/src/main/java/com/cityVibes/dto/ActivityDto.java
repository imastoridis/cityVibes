package com.cityVibes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO for Review entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDto {
    private Long id;
    private String activity;
    private Long cityId;
}
