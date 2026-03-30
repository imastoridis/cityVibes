
package com.cityVibes.model.entity;

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
    private Set<CityVibes> cityVibes;

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