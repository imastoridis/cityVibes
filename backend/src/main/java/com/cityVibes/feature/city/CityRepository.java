package com.cityVibes.feature.city;

import com.cityVibes.feature.city.dto.response.CityResponseRecord;
import com.cityVibes.feature.city.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
     * @return City record
     *
     */
    Optional<CityResponseRecord> findProjectedById(Long id);

    /**
     * @return List of all cities
     *
     */
    List<CityResponseRecord> findAllBy();

}
