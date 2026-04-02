package com.cityVibes.mapper;

import com.cityVibes.dto.VibeDto;
import com.cityVibes.model.entity.Vibe;

public class VibeMapper {
    // Convert Entity to DTO
    public static VibeDto toDto(Vibe vibe) {
        if (vibe == null) return null;

        VibeDto dto = new VibeDto();
        dto.setId(vibe.getId());
        dto.setName(vibe.getName());
        dto.setIsPositive(vibe.getIsPositive());
        return dto;
    }

    // Convert DTO to Entity
    public static Vibe toEntity(VibeDto vibeDto) {

        if (vibeDto == null) return null;

        Vibe vibe = new Vibe();
        vibe.setName(vibeDto.getName());
        vibe.setIsPositive(vibeDto.getIsPositive());
        return vibe;
    }
}
