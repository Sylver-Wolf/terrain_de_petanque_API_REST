package com.polytech.polytech.DTO;

import com.polytech.polytech.entity.ReservationKey;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class ReservationDTO {

    private ReservationKey id;

    private com.polytech.polytech.entity.Utilisateur Utilisateur;

    private com.polytech.polytech.entity.Terrain Terrain;

    private int reservation;


    public ReservationDTO() {

    }
}
