package com.polytech.polytech.creationDTO;

import com.polytech.polytech.entity.ReservationKey;


public class ReservationCreationDTO {

    private ReservationKey id;

    private com.polytech.polytech.entity.Utilisateur Utilisateur;

    private com.polytech.polytech.entity.Terrain Terrain;

    private int reservation;


    public ReservationCreationDTO() {

    }

    public ReservationKey getId() {
        return id;
    }

    public com.polytech.polytech.entity.Utilisateur getUtilisateur() {
        return Utilisateur;
    }

    public com.polytech.polytech.entity.Terrain getTerrain() {
        return Terrain;
    }

    public int getReservation() {
        return reservation;
    }
}
