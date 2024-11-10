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
public class Reservation {

    @EmbeddedId
    private ReservationKey id;

    @ManyToOne
    //@MapsId("utilisateurId" )
    @JoinColumn(name="utilisateur", insertable = false, updatable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    //@MapsId("terrainId" )
    @JoinColumn(name="terrain", insertable = false, updatable = false)
    private Terrain terrain;

    private int reservation;


    public Reservation() {

    }
}