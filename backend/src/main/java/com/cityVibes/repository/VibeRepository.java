package com.cityVibes.repository;

import com.cityVibes.dto.record.UserRecord;
import com.cityVibes.dto.record.VibeRecord;
import com.cityVibes.model.entity.Vibe;
import com.cityVibes.model.entity.Vibe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VibeRepository extends JpaRepository<Vibe, Long> {
    /**
     * @param id - id of the vibe
     * @return record
     *
     */
    VibeRecord findProjectedById(Long id);

    /**
     * @param name - name of the vibe
     * @return record
     *
     */
    VibeRecord findVibeByName(String name);


    /**
     * @param id - id of the vibe
     * @return entity
     *
     */
    Vibe findVibeById(Long id);
}
