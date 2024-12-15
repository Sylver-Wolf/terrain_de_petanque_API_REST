package com.polytech.polytech.service;

import com.polytech.polytech.entity.Reservation;
import com.polytech.polytech.entity.ReservationKey;
import com.polytech.polytech.entity.Terrain;
import com.polytech.polytech.entity.Utilisateur;
import com.polytech.polytech.exception.AlreadyExistReservation;
import com.polytech.polytech.exception.TerrainNotFoundException;
import com.polytech.polytech.exception.UserNotFoundException;
import com.polytech.polytech.repository.ReservationRepository;
import com.polytech.polytech.repository.TerrainRepository;
import com.polytech.polytech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepo;

    @Autowired
    private TerrainRepository terrainRepo;

    @Autowired
    private UserRepository utilisateurRepo;

    /**
     * Récupère toutes les réservations présente dans la BDD
     *
     * @return
     */
    public List<Reservation> getAllReservation() {
        return reservationRepo.findAll();
    }

    /**
     * Récupère les réservations associé à l'id d'un utilisateur
     *
     * @param userId Id de l'utilisateur dont on souhaite récupérer les réservation associé
     * @return
     */
    public List<Reservation> getReservByUserId(Integer userId) {
        return reservationRepo.findByUtilisateur_Id(userId);
    }

    /**
     * Récupère les réservations associé à l'id d'un terrain
     *
     * @param terrainId Id du terrain dont on cherche les réservation associé
     * @return Liste de réservation
     */
    public List<Reservation> getReservByTerrainId(Integer terrainId) {
        return reservationRepo.findByTerrain_Id(terrainId);
    }

    /**
     * Créer une réservation dans la base de données en indiquant l'id du terrain et de l'utilisateur associé
     *
     * @param utilisateurId Utilisateur qui effectue la réservation
     * @param terrainId Terrain qui a été réservé
     * @return
     */
    public Reservation reserverTerrain(Integer utilisateurId, Integer terrainId) {

        Utilisateur util = utilisateurRepo.findById(utilisateurId).orElseThrow(UserNotFoundException::new);
        Terrain ter = terrainRepo.findById(terrainId).orElseThrow(TerrainNotFoundException::new);

        //Création de la clé
        ReservationKey reservationKey = new ReservationKey();
        reservationKey.setTerrain_id(ter.getId());
        reservationKey.setUtilisateur_id(util.getId());

        //Création de la reservation dans la BDD
        Reservation reserv = new Reservation();
        reserv.setUtilisateur(util);
        reserv.setTerrain(ter);
        reserv.setId(reservationKey);

        if(this.reservationRepo.existsById(reservationKey)) {
            //Ajouter une exception
            throw new AlreadyExistReservation();
        }

        return reservationRepo.save(reserv);
    }

    /**
     *
     *
     * @param terrainId Id du terrain associé à la reservation
     * @param utilisateurId Id de l'utilisateur associé à la reservation
     * @return code d'erreur concernant la suppression de la réservation
     */
    public int supprimmerReserv(Integer terrainId, Integer utilisateurId) {
        ReservationKey resKey = new ReservationKey();
        resKey.setUtilisateur_id(utilisateurId);
        resKey.setTerrain_id(terrainId);
        if(this.reservationRepo.existsById(resKey)) {

            this.reservationRepo.deleteById(resKey);
            return 0;
        }
        return 1;


    }

}
