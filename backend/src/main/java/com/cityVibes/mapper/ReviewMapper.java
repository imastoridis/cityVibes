package com.cityVibes.mapper;

import com.cityVibes.dto.ReviewDto;
import com.cityVibes.model.entity.City;
import com.cityVibes.model.entity.Review;
import com.cityVibes.model.entity.User;

public class ReviewMapper {

    // Convert Entity to DTO
    public static ReviewDto toDto(Review review) {
        if (review == null) return null;

        ReviewDto dto = new ReviewDto();
        dto.setId(review.getId());
        dto.setReview(review.getReview());
        dto.setRating(review.getRating());
        dto.setUserId(review.getUser().getId());
        dto.setCityId(review.getCity().getId());
        dto.setCreatedAt(review.getCreatedAt());
        return dto;
    }

    // Convert DTO to Entity
    public static Review toEntity(ReviewDto reviewDto, User user, City city) {

        if (reviewDto == null) return null;

        Review review = new Review();
        review.setReview(reviewDto.getReview());
        review.setRating(reviewDto.getRating());
        review.setUser(user);
        review.setCity(city);
        review.setCreatedAt(reviewDto.getCreatedAt());
        return review;
    }

}
