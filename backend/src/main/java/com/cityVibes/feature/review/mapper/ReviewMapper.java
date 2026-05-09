package com.cityVibes.feature.review.mapper;

import com.cityVibes.feature.review.entity.Review;
import com.cityVibes.feature.review.dto.response.ReviewResponse;
/*
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring") // Permet l'injection via @Autowired
public interface ReviewMapper {

    @Mapping(source = "users.id", target = "userId")
    @Mapping(source = "users.username", target = "username")
    @Mapping(source = "city.id", target = "cityId")
    ReviewResponse toResponse(Review review);

    // Si tu as besoin de faire l'inverse pour la création
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "users", ignore = true) // À gérer manuellement dans le service
    @Mapping(target = "city", ignore = true)
    Review toEntity(ReviewResponse dto);
}*/
