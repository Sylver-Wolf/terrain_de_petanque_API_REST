package com.polytech.polytech.entity;

import jakarta.persistence.*;
import lombok.*;
import com.polytech.polytech.entity.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Table(name = "reservation")
@NoArgsConstructor
public class Reservation {

    @EmbeddedId
    private ReservationKey id;

    @ManyToOne
    @MapsId("utilisateur_id" )
    @JoinColumn(name="utilisateur_id", insertable = false, updatable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @MapsId("terrain_id" )
    @JoinColumn(name="terrain_id", insertable = false, updatable = false)
    private Terrain terrain;

}