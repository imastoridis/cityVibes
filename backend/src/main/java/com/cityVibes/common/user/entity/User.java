package com.cityVibes.common.user.entity;

import com.cityVibes.feature.cityvibe.entity.Cityvibe;
import com.cityVibes.feature.review.entity.Review;
import com.cityVibes.common.entity.BaseAuditEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;
import java.util.Set;

// Maps this class to the 'users' table in the database
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@SuppressWarnings("unused")

public class User extends BaseAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    private String firstName;
    private String lastName;
    private String passwordHash;

    /* Vibes that belongs to this user*/
    @OneToMany(mappedBy = "user", cascade = {CascadeType.MERGE})
    private Set<Cityvibe> cityvibes;

    /* Reviews that belong to this user*/
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;
}