package com.polytech.polytech.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Table(name = "terrain")
public class Terrain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="nom")
    private String nom;

    @Column(name="quantite")
    private int quantite;

    @Column(name="description")
    private String description;

    @Column(name="point_geo")
    private String point_geo;

    //@OneToMany(mappedBy = "terrain")
    //Set<Reservation> Reservations;


    public Terrain() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoint_geo() {
        return point_geo;
    }

    public void setPoint_geo(String point_geo) {
        this.point_geo = point_geo;
    }

    /*public Set<Reservation> getReservations() {
        //return Reservations;
    }*/

    /*public void setReservations(Set<Reservation> reservations) {
        Reservations = reservations;
    }*/
}
