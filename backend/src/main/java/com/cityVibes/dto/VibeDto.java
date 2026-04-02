package com.cityVibes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO for vibe entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VibeDto {
    private Long id;
    private Boolean isPositive;
    private String name;
}
