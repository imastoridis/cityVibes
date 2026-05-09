package com.cityVibes.feature.city;

import com.cityVibes.common.response.ApiResponse;
import com.cityVibes.feature.city.dto.response.CityResponseRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/city")
@SuppressWarnings("unused")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    /**
     * GET /api/city/all: Get all cities
     *
     * @return A list of cities
     */
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<CityResponseRecord>>> findAllCities() {
        List<CityResponseRecord> data = cityService.findAllCities();
        return ResponseEntity.ok(ApiResponse.success(data, "Cities retrieved successfully"));
    }

    /**
     * GET /api/city/{id}: Get one city by id
     *
     * @param id - id of the city
     * @return A city
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CityResponseRecord>> findCity(
            @PathVariable Long id
    ) {
        CityResponseRecord data = cityService.findCityById(id);
        return ResponseEntity.ok(ApiResponse.success(data, "City details retrieved"));
    }
}
