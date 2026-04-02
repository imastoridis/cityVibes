package com.cityVibes.repository;

import com.cityVibes.dto.record.UserRecord;
import com.cityVibes.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * @param id - id of the user
     * @return record
     *
     */
    UserRecord findProjectedById(Long id);

    /**
     * @param username - username of the user
     * @return record
     *
     */
    UserRecord findUserByUsername(String username);

    /**
     * @param id - id of the user
     * @return entity
     *
     */
    User findUserById(Long id);


}
