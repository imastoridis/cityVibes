package com.cityVibes.feature.activity;

import com.cityVibes.feature.activity.dto.request.ActivityRequest;
import com.cityVibes.feature.activity.dto.response.ActivityResponse;

public interface ActivityService {
    /**
     * Get activity by id
     *
     * @param id - id of the activity
     * @return activity with id
     *
     */
    ActivityResponse findActivityById(Long id);

    /**
     * Create activity
     *
     * @param request Activity data
     * @return ActivityDto
     *
     */
    ActivityResponse createActivity(ActivityRequest request);

    /**
     * Update Activity
     *
     * @param request - modified activity
     * @param id - activity id
     *
     */
    void updateActivity(ActivityRequest request,Long id);

    /**
     * Delete Activity
     *
     * @param id - id of the activity
     *
     */
    void deleteActivity(Long id);
}
