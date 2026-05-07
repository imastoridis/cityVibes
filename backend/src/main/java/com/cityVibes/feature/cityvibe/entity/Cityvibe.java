package com.cityVibes.feature.cityvibe.entity;

import com.cityVibes.common.user.entity.User;
import com.cityVibes.feature.city.entity.City;
import com.cityVibes.feature.vibe.entity.Vibe;
import com.cityVibes.common.entity.BaseAuditEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "city_vibes")
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
/* Table that connects cities to vibes and users*/
public class Cityvibe extends BaseAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* Many users can have many vibes*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    /* Many cities can have many vibes*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private City city;

    /* Many vibes can have many cities*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vibe_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Vibe vibe;
}
