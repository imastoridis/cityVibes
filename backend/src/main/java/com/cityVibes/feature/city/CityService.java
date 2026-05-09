package com.cityVibes.feature.city;


import com.cityVibes.feature.city.dto.response.CityResponseRecord;

import java.util.List;

public interface CityService {

    /**
     * Get city by id
     *
     * @param id - id of the city
     * @return City with id
     *
     */
    CityResponseRecord findCityById(Long id);

    /**
     * Get all cities
     *
     * @return List of all cities
     */
    List<CityResponseRecord> findAllCities();
}
