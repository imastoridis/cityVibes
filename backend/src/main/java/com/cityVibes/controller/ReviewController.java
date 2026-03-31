package com.cityVibes.controller;

import com.cityVibes.dto.ApiResponse;
import com.cityVibes.dto.ReviewDto;
import com.cityVibes.dto.projection.ReviewSummary;
import com.cityVibes.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/review")
@SuppressWarnings("unused")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    /**
     * GET /api/review/{id}: Get one review by id
     *
     * @param id - id of the review
     * @return A review
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ReviewSummary>> findReview(
            @PathVariable Long id
    ) {
        ReviewSummary data = reviewService.findReviewById(id);
        return ResponseEntity.ok(ApiResponse.success(data, "Review details retrieved"));
    }


    /**
     * POST /api/review: Create one review
     *
     * @param reviewDto - review to create
     * @return A review
     */
    @PostMapping("/")
    public ResponseEntity<ApiResponse<ReviewDto>> createReview(
            @Valid @RequestBody ReviewDto reviewDto
    ) {
        Long userId = 1L;
        ReviewDto data = reviewService.createReview(reviewDto, userId);
        return ResponseEntity.ok(ApiResponse.success(data, "Review created"));
    }

    /**
     * PUT /api/review/{id}: Updates one review
     *
     * @param reviewDto - modified review
     * @return Void
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updateReview(
            @Valid @RequestBody ReviewDto reviewDto
    ) {
        reviewService.updateReview(reviewDto);
        return ResponseEntity.ok(ApiResponse.success(null, "Review updated"));
    }

    /**
     * DELETE /api/review/{id}: Deletes one review
     *
     * @param id - id of the review
     * @return Void
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteReview(
            @PathVariable Long id
    ) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok(ApiResponse.<Void>success(null, "Review deleted"));
    }


}
