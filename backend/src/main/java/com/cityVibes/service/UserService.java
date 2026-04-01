package com.cityVibes.service;

import com.cityVibes.dto.UserDto;
import com.cityVibes.dto.record.UserRecord;

public interface UserService {


    /**
     * Get user by id
     *
     * @param id - id of the user
     * @return user with id
     *
     */
    UserRecord findUserById(Long id);


    /**
     * Create user
     *
     * @param userDto User data
     * @return UserDto
     *
     */
    UserDto createUser(UserDto userDto);

    /**
     * Update User
     *
     * @param userDto - modified user
     *
     */
    void updateUser(UserDto userDto);


    /**
     * Delete User
     *
     * @param id - id of the user
     *
     */
    void deleteUser(Long id);

}
