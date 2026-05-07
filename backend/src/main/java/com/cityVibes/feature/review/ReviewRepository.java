package com.cityVibes.feature.review;

import com.cityVibes.feature.review.dto.ReviewRecord;
import com.cityVibes.feature.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    /**
     * @param id - id of the review
     * @return record
     *
     */
    ReviewRecord findProjectedById(Long id);

    /**
     * @param id - id of the review
     * @return entity
     *
     */
    Review findReviewById(Long id);
}
