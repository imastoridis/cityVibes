package com.cityVibes.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

// Maps this class to the 'users' table in the database
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String passwordHash;

    /* Vibe that belongs to this user*/
    @OneToMany(mappedBy = "user", cascade = {CascadeType.MERGE})
    private Set<CityVibes> cityVibes;

    /* Reviews that belongs to this user*/
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;
}