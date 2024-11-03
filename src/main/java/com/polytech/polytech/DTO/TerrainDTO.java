package com.polytech.polytech.DTO;

import com.polytech.polytech.entity.Reservation;
import lombok.*;

import java.util.Set;


@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class TerrainDTO {

    private Long id;
    private String nom;
    private int quantite;
    private String description;
    private String point_geo;
    Set<Reservation> Reservations;

    public TerrainDTO() {

    }
}
