package com.cityVibes.repository;

import com.cityVibes.dto.projection.CitySummary;
import com.cityVibes.model.entity.City;
import com.cityVibes.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {


    /**
     * @param id - id of the city
     * @return City entity
     *
     */
    City findCityById(Long id);

    /**
     * @param id - id of the city
     * @return City projection
     *
     */
    CitySummary findProjectedById(Long id);

    /**
     * @return List of all cities
     *
     */
    List<CitySummary> findAllBy();

}
