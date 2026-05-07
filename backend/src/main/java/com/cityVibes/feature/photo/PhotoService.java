package com.cityVibes.feature.photo;

import com.cityVibes.feature.city.entity.City;
import com.cityVibes.feature.photo.entity.Photo;
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
