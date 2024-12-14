package com.polytech.polytech.repository;

import com.polytech.polytech.entity.Reservation;
import com.polytech.polytech.entity.ReservationKey;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, ReservationKey> {
    List<Reservation> findByUtilisateur_Id(Integer utilisateurId); // Trouver les réservations d'un utilisateur
    List<Reservation> findByTerrain_Id(Integer terrainId);

}
