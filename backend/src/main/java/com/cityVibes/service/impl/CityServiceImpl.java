package com.cityVibes.service.impl;

import com.cityVibes.dto.projection.CitySummary;
import com.cityVibes.repository.CityRepository;
import com.cityVibes.service.CityService;
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
    public List<CitySummary> findAllCities() {
        return cityRepository.findAllBy();
    }

    /**
     * Get city by id
     *
     * @param id - id of the city
     * @return City with id
     */
    @Override
    public CitySummary findCityById(Long id) {
        // Here you could throw a custom ResourceNotFoundException if it's null
        return cityRepository.findProjectedById(id);
    }

}
