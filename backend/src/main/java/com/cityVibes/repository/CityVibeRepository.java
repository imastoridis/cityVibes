package com.cityVibes.repository;
import com.cityVibes.model.entity.CityVibes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityVibeRepository extends JpaRepository<CityVibes, Long> {
}
