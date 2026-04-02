package com.cityVibes.service.impl;

import com.cityVibes.annotation.vibe.EvictAllVibeCache;
import com.cityVibes.annotation.vibe.EvictOneVibeCache;
import com.cityVibes.dto.VibeDto;
import com.cityVibes.dto.record.VibeRecord;
import com.cityVibes.exception.DuplicateResourceException;
import com.cityVibes.mapper.VibeMapper;
import com.cityVibes.model.entity.Vibe;
import com.cityVibes.repository.VibeRepository;
import com.cityVibes.service.VibeService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VibeServiceImpl implements VibeService {
    private final VibeRepository vibeRepository;

    public VibeServiceImpl(
            VibeRepository vibeRepository
    ) {
        this.vibeRepository = vibeRepository;
    }

    /**
     * Get vibe by id
     *
     * @param id - id of the vibe
     * @return vibe with id
     */
    @Override
    @Cacheable(value = "one_vibe", key = "#id")
    public VibeRecord findVibeById(Long id) {
        return vibeRepository.findProjectedById(id);
    }

    /**
     * Create vibe
     *
     * @param vibeDto - vibe data
     * @return vibe with id
     */
    @Override
    @Transactional
    @EvictAllVibeCache
    public VibeDto createVibe(VibeDto vibeDto) {
        VibeRecord existingVibe = vibeRepository.findVibeByName(vibeDto.getName());

        if (existingVibe == null) {
            Vibe newVibe = VibeMapper.toEntity(vibeDto);
            vibeRepository.save(newVibe);
            return VibeMapper.toDto(newVibe);
        } else {
            throw new DuplicateResourceException(String.format(
                    "Vibe '%s' already exists, please choose another", vibeDto.getName()));
        }
    }

    /**
     * Update vibe
     *
     * @param vibeDto - modified vibe
     */
    @Override
    @Transactional
    @EvictAllVibeCache
    @EvictOneVibeCache
    public void updateVibe(VibeDto vibeDto) {
        Vibe vibe = vibeRepository.findVibeById(vibeDto.getId());

        vibe.setName(vibeDto.getName());
        vibe.setIsPositive(vibeDto.getIsPositive());

        vibeRepository.save(vibe);
    }

    /**
     * Delete vibe
     *
     * @param id - id of the vibe
     */
    @Override
    @Transactional
    @EvictAllVibeCache
    @EvictOneVibeCache
    public void deleteVibe(Long id) {
        Vibe vibe = vibeRepository.findVibeById(id);
        vibeRepository.delete(vibe);
    }
}
