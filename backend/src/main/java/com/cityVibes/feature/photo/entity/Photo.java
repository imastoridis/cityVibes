package com.cityVibes.feature.photo.entity;
import com.cityVibes.feature.city.entity.City;
import com.cityVibes.feature.review.entity.Review;
import com.cityVibes.common.entity.BaseAuditEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "photos")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Photo extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String fileUrl; // Path to where the image is stored (e.g., /uploads/cities/paris.jpg)

    private String fileType; // "image/jpeg"

    private Long fileSize;

    /* Many photos can belong to one city*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private City city;

    /* Many photos can belong to one review*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Review review;
}
