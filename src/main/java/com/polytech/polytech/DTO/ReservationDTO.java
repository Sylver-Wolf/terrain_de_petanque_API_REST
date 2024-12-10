package com.polytech.polytech.DTO;

import com.polytech.polytech.entity.ReservationKey;
import com.polytech.polytech.entity.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@ToString
public class ReservationDTO {

    private ReservationKey id;

    private Utilisateur Utilisateur;

    private Terrain Terrain;


}
