package com.cityVibes.repository;

import com.cityVibes.dto.ReviewDto;
import com.cityVibes.dto.projection.ReviewSummary;
import com.cityVibes.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    /**
     * @param id - id of the review
     * @return projection
     *
     */
    ReviewSummary findProjectedById(Long id);

    /**
     * @param id - id of the review
     * @return entity
     *
     */
    Review findReviewById(Long id);
}
