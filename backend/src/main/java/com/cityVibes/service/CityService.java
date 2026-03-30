package com.cityVibes.service;


import com.cityVibes.dto.CitySummary;

import java.util.List;

public interface CityService {

    /**
     * Get city by id
     *
     * @param id - id of the city
     * @return City with id
     *
     */
    CitySummary findCityById(Long id);

    /**
     * Get all cities
     *
     * @return List of all cities
     */
    List<CitySummary> findAllCities();
}
