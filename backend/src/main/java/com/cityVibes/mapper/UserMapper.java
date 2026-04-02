package com.cityVibes.mapper;

import com.cityVibes.dto.UserDto;
import com.cityVibes.model.entity.User;

public class UserMapper {

    // Convert Entity to DTO
    public static UserDto toDto(User user) {
        if (user == null) return null;

        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setPasswordHash(user.getPasswordHash());
        dto.setUsername(user.getUsername());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setUpdatedAt(user.getUpdatedAt());
        dto.setCreatedAt(user.getCreatedAt());
        return dto;
    }

    // Convert DTO to Entity
    public static User toEntity(UserDto userDto) {

        if (userDto == null) return null;

        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPasswordHash(userDto.getPasswordHash());
        user.setUsername(userDto.getUsername().replaceAll("\\s+", ""));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUpdatedAt(userDto.getUpdatedAt());
        user.setCreatedAt(userDto.getCreatedAt());
        return user;
    }
}
