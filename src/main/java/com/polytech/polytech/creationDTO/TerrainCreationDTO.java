package com.polytech.polytech.creationDTO;

import com.polytech.polytech.entity.Reservation;

import java.util.Set;

public class TerrainCreationDTO {

    private Long id;
    private String nom;
    private int quantite;
    private String description;
    private String point_geo;
    Set<Reservation> Reservations;

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getDescription() {
        return description;
    }

    public String getPoint_geo() {
        return point_geo;
    }

    public Set<Reservation> getReservations() {
        return Reservations;
    }
}
