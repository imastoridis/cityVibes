package com.cityVibes.feature.cityvibe;
import com.cityVibes.feature.cityvibe.entity.Cityvibe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityvibeRepository extends JpaRepository<Cityvibe, Long> {
}
