package com.cityVibes.common.user;

import com.cityVibes.common.user.dto.UserDto;
import com.cityVibes.common.user.dto.UserRecord;
import com.cityVibes.exception.DuplicateResourceException;
import com.cityVibes.common.user.mapper.UserMapper;
import com.cityVibes.common.user.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@SuppressWarnings("unused")
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    /**
     * Get user by id
     *
     * @param id - id of the user
     * @return user with id
     */
    @Override
    public UserRecord findUserById(Long id) {
        return userRepository.findProjectedById(id);
    }

    /**
     * Create user
     *
     * @param userDto - user to create
     * @return user with id
     */
    @Override
    @Transactional
    public UserDto createUser(UserDto userDto) {
        UserRecord user = userRepository.findUserByUsername(userDto.getUsername().replaceAll("\\s+", ""));

        if (user == null) {
            User newUser = UserMapper.toEntity(userDto);
            userRepository.save(newUser);
            return UserMapper.toDto(newUser);
        } else {
            throw new DuplicateResourceException(String.format(
                    "Username '%s' already exists, please choose another", userDto.getUsername()));
        }
    }

    /**
     * Update user
     *
     * @param userDto - modified user
     */
    @Override
    @Transactional
    public void updateUser(UserDto userDto) {
        User existingUser = userRepository.findUserById(userDto.getId());

        existingUser.setEmail(userDto.getEmail());
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());

        userRepository.save(existingUser);
    }

    /**
     * Delete user
     *
     * @param id - id of the user
     */
    @Override
    @Transactional
    public void deleteUser(Long id) {
        User user = userRepository.findUserById(id);
        userRepository.delete(user);
    }
}
