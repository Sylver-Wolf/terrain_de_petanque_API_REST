package com.polytech.polytech.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Table(name = "reservation")
public class Reservation {

    @EmbeddedId
    private ReservationKey id;

    @ManyToOne
    @MapsId("utilisateurId" )
    @JoinColumn(name="utilisateur_id")
    private com.polytech.polytech.entity.Utilisateur Utilisateur;

    @ManyToOne
    @MapsId("terrainId" )
    @Column(name="terrain_id")
    private com.polytech.polytech.entity.Terrain Terrain;

    private int reservation;


    public Reservation() {

    }
}
