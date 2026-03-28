package com.cityVibes.service;

import com.cityVibes.model.entity.City;
import com.cityVibes.model.entity.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Interface defining methods for PhotoService
 */
public interface PhotoService {

    /**
     * Save photo to the database
     *
     * @param file
     * @param city
     * @return Photo
     *
     */
    Photo savePhoto(MultipartFile file, City city) throws IOException;
}
