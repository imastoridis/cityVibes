package com.cityVibes.feature.activity;

import com.cityVibes.annotation.activity.EvictAllActivityCache;
import com.cityVibes.annotation.activity.EvictOneActivityCache;
import com.cityVibes.feature.activity.dto.request.ActivityRequest;
import com.cityVibes.feature.activity.dto.response.ActivityResponse;
import com.cityVibes.feature.activity.mapper.ActivityMapper;
import com.cityVibes.feature.city.entity.City;
import com.cityVibes.feature.activity.entity.Activity;
import com.cityVibes.feature.activity.entity.CultureActivity;
import com.cityVibes.feature.activity.entity.FoodActivity;
import com.cityVibes.feature.activity.entity.OutdoorActivity;
import com.cityVibes.feature.city.CityRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@SuppressWarnings("unused")
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
    public ActivityResponse findActivityById(Long id) {
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Activity not found"));
        return ActivityMapper.toResponse(activity);
    }

    /**
     * Create activity
     *
     * @param request - Activity data
     * @return activity entity
     */
    @Override
    @Transactional
    @EvictAllActivityCache
    public ActivityResponse createActivity(ActivityRequest request) {
        City city = cityRepository.findById(request.cityId())
                .orElseThrow(() -> new EntityNotFoundException("City not found"));

        Activity entity = switch (request) {
            case ActivityRequest.Food f -> {
                FoodActivity food = new FoodActivity();
                food.setCuisineType(f.cuisineType());
                food.setAveragePrice(f.averagePrice());
                yield food;
            }
            case ActivityRequest.Outdoor o -> {
                OutdoorActivity outdoor = new OutdoorActivity();
                outdoor.setDifficulty(o.difficulty());
                yield outdoor;
            }
            case ActivityRequest.Culture c -> {
                CultureActivity culture = new CultureActivity();
                culture.setTheme(c.theme());
                yield culture;
            }
        };

        entity.setActivity(request.activity());
        entity.setCity(city);

        activityRepository.save(entity);
        return ActivityMapper.toResponse(entity);
    }

    /**
     * Update activity
     *
     * @param request - modified activity
     * @param id      - activity id
     */
    @Override
    @Transactional
    @EvictAllActivityCache
    @EvictOneActivityCache
    public void updateActivity(ActivityRequest request, Long id) {
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Activity not found"));

        activity.setActivity(request.activity());

        switch (request) {
            case ActivityRequest.Food f when activity instanceof FoodActivity food -> {
                food.setCuisineType(f.cuisineType());
                food.setAveragePrice(f.averagePrice());
            }
            case ActivityRequest.Outdoor o when activity instanceof OutdoorActivity outdoor ->
                    outdoor.setDifficulty(o.difficulty());
            case ActivityRequest.Culture c when activity instanceof CultureActivity culture ->
                    culture.setTheme(c.theme());

            default ->
                    throw new IllegalArgumentException("Le type de mise à jour ne correspond pas au type de l'activité éxistante");
        }

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
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Activity not found"));
        activityRepository.delete(activity);
    }
}
