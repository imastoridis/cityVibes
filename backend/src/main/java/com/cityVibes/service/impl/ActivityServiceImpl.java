package com.cityVibes.service.impl;

import com.cityVibes.annotation.activity.EvictAllActivityCache;
import com.cityVibes.annotation.activity.EvictOneActivityCache;
import com.cityVibes.dto.ActivityDto;
import com.cityVibes.dto.record.ActivityRecord;
import com.cityVibes.mapper.ActivityMapper;
import com.cityVibes.model.entity.City;
import com.cityVibes.model.entity.Activity;
import com.cityVibes.repository.CityRepository;
import com.cityVibes.repository.ActivityRepository;
import com.cityVibes.service.ActivityService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository activityRepository;
    private final CityRepository cityRepository;

    public ActivityServiceImpl(
            ActivityRepository activityRepository,
            CityRepository cityRepository
    ) {
        this.activityRepository = activityRepository;
        this.cityRepository = cityRepository;
    }

    /**
     * Get activity by id
     *
     * @param id - id of the activity
     * @return activity with id
     */
    @Override
    @Cacheable(value = "one_activity", key = "#id")
    public ActivityRecord findActivityById(Long id) {
        return activityRepository.findProjectedById(id);
    }

    /**
     * Create activity
     *
     * @param activityDto - id of the activity
     * @return activity with id
     */
    @Override
    @Transactional
    @EvictAllActivityCache
    public ActivityDto createActivity(ActivityDto activityDto) {
        City city = cityRepository.findCityById(activityDto.getCityId());

        Activity newActivity = ActivityMapper.toEntity(activityDto, city);
        activityRepository.save(newActivity);

        return ActivityMapper.toDto(newActivity);
    }

    /**
     * Update activity
     *
     * @param activityDto - modified activity
     */
    @Override
    @Transactional
    @EvictAllActivityCache
    @EvictOneActivityCache
    public void updateActivity(ActivityDto activityDto) {
        Activity activity = activityRepository.findActivityById(activityDto.getId());
        City city = cityRepository.findCityById(activityDto.getCityId());

        activity.setActivity(activityDto.getActivity());
        activity.setCity(city);

        activityRepository.save(activity);
    }

    /**
     * Delete activity
     *
     * @param id - id of the activity
     */
    @Override
    @Transactional
    @EvictAllActivityCache
    @EvictOneActivityCache
    public void deleteActivity(Long id) {
        Activity activity = activityRepository.findActivityById(id);
        activityRepository.delete(activity);
    }
}
