package com.cityVibes.controller;

import com.cityVibes.dto.ApiResponse;
import com.cityVibes.dto.ActivityDto;
import com.cityVibes.dto.record.ActivityRecord;
import com.cityVibes.service.ActivityService;
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
    public ResponseEntity<ApiResponse<ActivityRecord>> findActivity(
            @PathVariable Long id
    ) {
        ActivityRecord data = activityService.findActivityById(id);
        return ResponseEntity.ok(ApiResponse.success(data, "Activity details retrieved"));
    }


    /**
     * POST /api/activity: Create one activity
     *
     * @param activityDto - activity to create
     * @return An activity
     */
    @PostMapping
    public ResponseEntity<ApiResponse<ActivityDto>> createActivity(
            @Valid @RequestBody ActivityDto activityDto
    ) {
        ActivityDto data = activityService.createActivity(activityDto);
        return ResponseEntity.ok(ApiResponse.success(data, "Activity created"));
    }

    /**
     * PUT /api/activity/{id}: Updates one activity
     *
     * @param activityDto - modified activity
     * @return Void
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updateActivity(
            @Valid @RequestBody ActivityDto activityDto
    ) {
        activityService.updateActivity(activityDto);
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
