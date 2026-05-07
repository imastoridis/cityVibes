package com.cityVibes.feature.review;

import com.cityVibes.feature.review.dto.ReviewDto;
import com.cityVibes.feature.review.dto.ReviewRecord;

public interface ReviewService {

    /**
     * Get review by id
     *
     * @param id - id of the review
     * @return review with id
     *
     */
    ReviewRecord findReviewById(Long id);

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
