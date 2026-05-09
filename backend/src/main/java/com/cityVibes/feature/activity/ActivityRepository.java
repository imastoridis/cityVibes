package com.cityVibes.feature.activity;

import com.cityVibes.feature.activity.dto.response.ActivityResponse;
import com.cityVibes.feature.activity.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    /**
     * @param id - id of the activity
     * @return record
     *
     */
    ActivityResponse findProjectedById(Long id);

    /**
     * @param id - id of the activity
     * @return entity
     *
     */
    Optional<Activity> findActivityById(Long id);
}
