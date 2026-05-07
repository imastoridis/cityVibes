
package com.cityVibes.feature.city.entity;

import com.cityVibes.feature.activity.entity.Activity;
import com.cityVibes.feature.cityvibe.entity.Cityvibe;
import com.cityVibes.feature.photo.entity.Photo;
import com.cityVibes.feature.review.entity.Review;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "city")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;

    /* Vibe that belongs to a city*/
    @OneToMany(mappedBy = "city", cascade = {CascadeType.MERGE})
    private Set<Cityvibe> cityvibes;

    /* Reviews that belong to a city*/
    @OneToMany(mappedBy = "city")
    private List<Review> reviews;

    /* Photos that belong to a city*/
    @OneToMany(mappedBy = "city")
    private List<Photo> photos;

    /* Activities that belong to a city*/
    @OneToMany(mappedBy = "city")
    private List<Activity> activities;
}