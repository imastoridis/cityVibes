package com.cityVibes.feature.city;


import com.cityVibes.feature.city.dto.CityDetail;

import java.util.List;

public interface CityService {

    /**
     * Get city by id
     *
     * @param id - id of the city
     * @return City with id
     *
     */
    CityDetail findCityById(Long id);

    /**
     * Get all cities
     *
     * @return List of all cities
     */
    List<CityDetail> findAllCities();
}
