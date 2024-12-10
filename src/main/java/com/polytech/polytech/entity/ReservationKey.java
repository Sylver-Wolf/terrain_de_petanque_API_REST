package com.polytech.polytech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ReservationKey implements Serializable {

    @Column(name="utilisateur_id")
    private Integer utilisateur_id;

    @Column(name="terrain_id")
    private Integer terrain_id;

}
