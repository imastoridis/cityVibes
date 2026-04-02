package com.cityVibes.repository;
import com.cityVibes.dto.record.ActivityRecord;
import com.cityVibes.model.entity.Activity;
import com.cityVibes.model.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    /**
     * @param id - id of the activity
     * @return record
     *
     */
    ActivityRecord findProjectedById(Long id);

    /**
     * @param id - id of the activity
     * @return entity
     *
     */
    Activity findActivityById(Long id);

}
