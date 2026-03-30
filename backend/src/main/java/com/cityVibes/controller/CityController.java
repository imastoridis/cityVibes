package com.cityVibes.controller;

import com.cityVibes.dto.ApiResponse;
import com.cityVibes.dto.CitySummary;
import com.cityVibes.service.CityService;
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
    public ResponseEntity<ApiResponse<List<CitySummary>>> getAllCities() {
        List<CitySummary> data = cityService.findAllCities();
        return ResponseEntity.ok(ApiResponse.success(data, "Cities retrieved successfully"));
    }

    /**
     * GET /api/city/{id}: Get one city by id
     *
     * @param id - id of the city
     * @return A city
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CitySummary>> getCity(@PathVariable Long id) {
        CitySummary data = cityService.findCityById(id);
        return ResponseEntity.ok(ApiResponse.success(data, "City details retrieved"));
    }


}
