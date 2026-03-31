package com.cityVibes.service;

import com.cityVibes.dto.ReviewDto;
import com.cityVibes.dto.projection.ReviewSummary;

public interface ReviewService {

    /**
     * Get review by id
     *
     * @param id - id of the review
     * @return review with id
     *
     */
    ReviewSummary findReviewById(Long id);


    /**
     * Create review
     *
     * @param reviewDto Review data
     * @param userId    - id of the user
     * @return ReviewDto
     *
     */
    ReviewDto createReview(ReviewDto reviewDto, Long userId);

    /**
     * Update Review
     *
     * @param reviewDto - modified review
     *
     */
    void updateReview(ReviewDto reviewDto);


    /**
     * Delete Review
     *
     * @param id - id of the review
     *
     */
    void deleteReview(Long id);


}
