package com.cityVibes.repository;

import com.cityVibes.dto.record.CityRecord;
import com.cityVibes.model.entity.City;
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
     * @return City record
     *
     */
    CityRecord findProjectedById(Long id);

    /**
     * @return List of all cities
     *
     */
    List<CityRecord> findAllBy();

}
