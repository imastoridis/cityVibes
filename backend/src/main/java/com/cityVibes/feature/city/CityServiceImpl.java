package com.cityVibes.feature.city;

import com.cityVibes.feature.city.dto.response.CityResponseRecord;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("unused")
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    /**
     * Get all cities
     *
     * @return List of all cities
     */
    @Override
  //  @Cacheable(value = "all_city")
    public List<CityResponseRecord> findAllCities() {
        return cityRepository.findAllBy();
    }

    /**
     * Get city by id
     *
     * @param id - id of the city
     * @return City projection
     */
    @Override
   // @Cacheable(value = "one_city", key = "#id")
    public CityResponseRecord findCityById(Long id) {
        return cityRepository.findProjectedById(id)
                .orElseThrow(() -> new EntityNotFoundException("City not found"));
    }
}
