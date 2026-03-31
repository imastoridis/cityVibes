package com.cityVibes.controller;

import com.cityVibes.dto.ApiResponse;
import com.cityVibes.dto.UserDto;
import com.cityVibes.dto.projection.UserSummary;
import com.cityVibes.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@SuppressWarnings("unused")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * GET /api/user/{id}: Get one user by id
     *
     * @param id - id of the user
     * @return A user
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserSummary>> findUser(
            @PathVariable Long id
    ) {
        UserSummary data = userService.findUserById(id);
        return ResponseEntity.ok(ApiResponse.success(data, "User details retrieved"));
    }


    /**
     * POST /api/user: Create one user
     *
     * @param userDto - user to create
     * @return A user
     */
    @PostMapping("/")
    public ResponseEntity<ApiResponse<UserDto>> createUser(
            @Valid @RequestBody UserDto userDto
    ) {
        UserDto data = userService.createUser(userDto);
        return ResponseEntity.ok(ApiResponse.success(data, "User created"));
    }

    /**
     * PUT /api/user/{id}: Updates one user
     *
     * @param userDto - modified user
     * @return Void
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updateUser(
            @Valid @RequestBody UserDto userDto
    ) {
        userService.updateUser(userDto);
        return ResponseEntity.ok(ApiResponse.success(null, "User updated"));
    }

    /**
     * DELETE /api/user/{id}: Deletes one user
     *
     * @param id - id of the user
     * @return Void
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(
            @PathVariable Long id
    ) {
        userService.deleteUser(id);
        return ResponseEntity.ok(ApiResponse.<Void>success(null, "User deleted"));
    }
}
