package com.polytech.polytech.DTO;

import com.polytech.polytech.entity.ReservationKey;
import com.polytech.polytech.entity.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class ReservationDTO {

    private ReservationKey id;

    private Utilisateur Utilisateur;

    private Terrain Terrain;

    private int reservation;


    public ReservationDTO() {

    }
}
