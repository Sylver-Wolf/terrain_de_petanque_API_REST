package com.polytech.polytech.service;

import com.polytech.polytech.entity.Reservation;
import com.polytech.polytech.entity.ReservationKey;
import com.polytech.polytech.entity.Terrain;
import com.polytech.polytech.entity.Utilisateur;
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
     *
     * @return
     */
    public List<Reservation> getAllReservation() {
        return reservationRepo.findAll();
    }

    /**
     *
     * @param userId
     * @return
     */
    public List<Reservation> getReservByUserId(Integer userId) {
        return reservationRepo.findByUtilisateur_Id(userId);
    }

    /**
     *
     * @param terrainId
     * @return
     */
    public List<Reservation> getReservByTerrainId(Integer terrainId) {
        return reservationRepo.findByTerrain_Id(terrainId);
    }


    /**
     *
     * @param reservationId
     */
    public void deleteReservation(ReservationKey reservationId) {
        if(this.reservationRepo.findById(reservationId).orElse(null) != null) {
            this.reservationRepo.deleteById(reservationId);
        }
        else throw new RuntimeException("Reservation with id " + reservationId + " not found");
    }

    /**
     *
     * @param utilisateurId
     * @param terrainId
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
            return null;
        }

        return reservationRepo.save(reserv);
    }

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
