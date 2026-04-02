package com.cityVibes.service.impl;

import com.cityVibes.annotation.review.EvictOneReviewCache;
import com.cityVibes.dto.ReviewDto;
import com.cityVibes.dto.record.ReviewRecord;
import com.cityVibes.mapper.ReviewMapper;
import com.cityVibes.model.entity.City;
import com.cityVibes.model.entity.Review;
import com.cityVibes.model.entity.User;
import com.cityVibes.repository.CityRepository;
import com.cityVibes.repository.ReviewRepository;
import com.cityVibes.repository.UserRepository;
import com.cityVibes.service.ReviewService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cityVibes.annotation.review.EvictAllReviewCache;

import java.time.LocalDateTime;

@Service
@SuppressWarnings("unused")
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final CityRepository cityRepository;

    public ReviewServiceImpl(
            ReviewRepository reviewRepository,
            UserRepository userRepository,
            CityRepository cityRepository
    ) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.cityRepository = cityRepository;
    }

    /**
     * Get review by id
     *
     * @param id - id of the review
     * @return review with id
     */
    @Override
    @Cacheable(value = "one_review", key = "#id")
    public ReviewRecord findReviewById(Long id) {
        return reviewRepository.findProjectedById(id);
    }

    /**
     * Create review
     *
     * @param userId - id of the review
     * @param reviewDto - review data
     * @return review with id
     */
    @Override
    @Transactional
    @EvictAllReviewCache
    public ReviewDto createReview(ReviewDto reviewDto, Long userId) {
        User user = userRepository.findUserById(userId);
        City city = cityRepository.findCityById(reviewDto.getCityId());

        Review newReview = ReviewMapper.toEntity(reviewDto, user, city);
        reviewRepository.save(newReview);

        return ReviewMapper.toDto(newReview);
    }

    /**
     * Update review
     *
     * @param reviewDto - modified review
     */
    @Override
    @Transactional
    @EvictAllReviewCache
    @EvictOneReviewCache
    public void updateReview(ReviewDto reviewDto) {
        Review review = reviewRepository.findReviewById(reviewDto.getId());

        review.setRating(reviewDto.getRating());
        review.setReview(reviewDto.getReview());
        review.setUpdatedAt(LocalDateTime.now());

        reviewRepository.save(review);
    }

    /**
     * Delete review
     *
     * @param id - id of the review
     */
    @Override
    @Transactional
    @EvictAllReviewCache
    @EvictOneReviewCache
    public void deleteReview(Long id) {
        Review review = reviewRepository.findReviewById(id);
        reviewRepository.delete(review);
    }
}
