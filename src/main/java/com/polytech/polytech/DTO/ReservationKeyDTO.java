package com.polytech.polytech.DTO;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@ToString
public class ReservationKeyDTO {
    private Integer utilisateur_id;

    private Integer terrain_id;
}
