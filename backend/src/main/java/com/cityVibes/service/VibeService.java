package com.cityVibes.service;

import com.cityVibes.dto.VibeDto;
import com.cityVibes.dto.record.VibeRecord;

public interface VibeService {
    /**
     * Get vibe by id
     *
     * @param id - id of the vibe
     * @return vibe with id
     *
     */
    VibeRecord findVibeById(Long id);

    /**
     * Create vibe
     *
     * @param vibeDto Vibe data
     * @return VibeDto
     *
     */
    VibeDto createVibe(VibeDto vibeDto);

    /**
     * Update Vibe
     *
     * @param vibeDto - modified vibe
     *
     */
    void updateVibe(VibeDto vibeDto);


    /**
     * Delete Vibe
     *
     * @param id - id of the vibe
     *
     */
    void deleteVibe(Long id);
}
