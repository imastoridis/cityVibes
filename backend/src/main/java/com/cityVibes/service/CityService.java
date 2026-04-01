package com.cityVibes.service;


import com.cityVibes.dto.record.CityRecord;

import java.util.List;

public interface CityService {

    /**
     * Get city by id
     *
     * @param id - id of the city
     * @return City with id
     *
     */
    CityRecord findCityById(Long id);

    /**
     * Get all cities
     *
     * @return List of all cities
     */
    List<CityRecord> findAllCities();
}
