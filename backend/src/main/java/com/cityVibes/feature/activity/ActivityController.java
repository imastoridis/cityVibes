package com.cityVibes.feature.activity;

import com.cityVibes.feature.activity.dto.request.ActivityRequest;
import com.cityVibes.feature.activity.dto.response.ActivityResponse;
import com.cityVibes.common.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/activity")
@SuppressWarnings("unused")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    /**
     * GET /api/activity/{id}: Get one activity by id
     *
     * @param id - id of the activity
     * @return An activity
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ActivityResponse>> findActivity(
            @PathVariable Long id
    ) {
        ActivityResponse data = activityService.findActivityById(id);
        return ResponseEntity.ok(ApiResponse.success(data, "Activity details retrieved"));
    }

    /**
     * POST /api/activity: Create one activity
     *
     * @param activityRequest - activity to create
     * @return An activity
     */
    @PostMapping
    public ResponseEntity<ApiResponse<ActivityResponse>> createActivity(
            @Valid @RequestBody ActivityRequest activityRequest
    ) {
        ActivityResponse data = activityService.createActivity(activityRequest);

        return ResponseEntity.ok(ApiResponse.success(data, "Activity created"));
    }

    /**
     * PUT /api/activity/{id}: Updates one activity
     *
     * @param activityRequest - modified activity
     * @return Void
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updateActivity(
            @Valid @RequestBody ActivityRequest activityRequest,
            @PathVariable Long id
    ) {
        activityService.updateActivity(activityRequest, id);
        return ResponseEntity.ok(ApiResponse.success(null, "Activity updated"));
    }

    /**
     * DELETE /api/activity/{id}: Deletes one activity
     *
     * @param id - id of the activity
     * @return Void
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteActivity(
            @PathVariable Long id
    ) {
        activityService.deleteActivity(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Activity deleted"));
    }

}
