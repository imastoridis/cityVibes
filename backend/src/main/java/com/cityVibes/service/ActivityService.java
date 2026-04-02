package com.cityVibes.service;

import com.cityVibes.dto.ActivityDto;
import com.cityVibes.dto.record.ActivityRecord;

public interface ActivityService {
    /**
     * Get activity by id
     *
     * @param id - id of the activity
     * @return activity with id
     *
     */
    ActivityRecord findActivityById(Long id);

    /**
     * Create activity
     *
     * @param activityDto Activity data
     * @return ActivityDto
     *
     */
    ActivityDto createActivity(ActivityDto activityDto);

    /**
     * Update Activity
     *
     * @param activityDto - modified activity
     *
     */
    void updateActivity(ActivityDto activityDto);

    /**
     * Delete Activity
     *
     * @param id - id of the activity
     *
     */
    void deleteActivity(Long id);
}
