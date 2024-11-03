package com.polytech.polytech.DTO;


import com.polytech.polytech.entity.Reservation;
import lombok.*;

import java.util.Set;


@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class UtilisateurDTO {

    private Long id;

    private String nom;

    private String prenom;

    private String mail;

    private String password;

    private String username;

    Set<Reservation> Reservations;

    public UtilisateurDTO() {

    }
}








