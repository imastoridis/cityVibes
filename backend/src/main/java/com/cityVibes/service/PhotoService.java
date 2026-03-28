package com.cityVibes.service;

import com.cityVibes.model.entity.City;
import com.cityVibes.model.entity.Photo;
import com.cityVibes.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class PhotoService {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private PhotoRepository photoRepository;

    public Photo savePhoto(MultipartFile file, City city) throws IOException {
        // 1. Create unique filename
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path targetPath = Paths.get(uploadPath).resolve(fileName);

        // 2. Save physical file to the Docker volume
        Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

        // 3. Save reference in Database
        Photo photo = new Photo();
        photo.setFileName(fileName);
        photo.setFileUrl("/api/photos/" + fileName); // URL for frontend to access
        photo.setCity(city);

        return photoRepository.save(photo);
    }
}
