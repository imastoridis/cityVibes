package com.cityVibes.controller;

import com.cityVibes.dto.VibeDto;
import com.cityVibes.dto.ApiResponse;
import com.cityVibes.dto.record.VibeRecord;
import com.cityVibes.service.VibeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vibe")
@SuppressWarnings("unused")
public class VibeController {
    private final VibeService vibeService;

    public VibeController(VibeService vibeService) {
        this.vibeService = vibeService;
    }

    /**
     * GET /api/vibe/{id}: Get one vibe by id
     *
     * @param id - id of the vibe
     * @return An vibe
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<VibeRecord>> findVibe(
            @PathVariable Long id
    ) {
        VibeRecord data = vibeService.findVibeById(id);
        return ResponseEntity.ok(ApiResponse.success(data, "Vibe details retrieved"));
    }


    /**
     * POST /api/vibe: Create one vibe
     *
     * @param vibeDto - vibe to create
     * @return An vibe
     */
    @PostMapping
    public ResponseEntity<ApiResponse<VibeDto>> createVibe(
            @Valid @RequestBody VibeDto vibeDto
    ) {
        VibeDto data = vibeService.createVibe(vibeDto);
        return ResponseEntity.ok(ApiResponse.success(data, "Vibe created"));
    }

    /**
     * PUT /api/vibe/{id}: Updates one vibe
     *
     * @param vibeDto - modified vibe
     * @return Void
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updateVibe(
            @Valid @RequestBody VibeDto vibeDto
    ) {
        vibeService.updateVibe(vibeDto);
        return ResponseEntity.ok(ApiResponse.success(null, "Vibe updated"));
    }

    /**
     * DELETE /api/vibe/{id}: Deletes one vibe
     *
     * @param id - id of the vibe
     * @return Void
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteVibe(
            @PathVariable Long id
    ) {
        vibeService.deleteVibe(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Vibe deleted"));
    }
}
