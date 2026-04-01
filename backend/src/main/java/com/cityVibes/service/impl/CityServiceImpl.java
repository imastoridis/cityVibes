package com.cityVibes.service.impl;

import com.cityVibes.dto.record.CityRecord;
import com.cityVibes.repository.CityRepository;
import com.cityVibes.service.CityService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    @Cacheable(value = "list_cities", key = "'all_cities'")
    public List<CityRecord> findAllCities() {
        return cityRepository.findAllBy();
    }

    /**
     * Get city by id
     *
     * @param id - id of the city
     * @return City with id
     */
    @Override
    @Cacheable(value = "one_city", key = "#id")
    public CityRecord findCityById(Long id) {
        // Here you could throw a custom ResourceNotFoundException if it's null
        return cityRepository.findProjectedById(id);
    }

}
