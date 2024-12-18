package com.polytech.polytech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ReservationKey implements Serializable {

    @Column(name="utilisateur_id")
    private int utilisateur_id;

    @Column(name="terrain_id")
    private int terrain_id;

}
