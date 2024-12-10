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

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepo;

    @Autowired
    private TerrainRepository terrainRepo;

    @Autowired
    private UserRepository utilisateurRepo;


    public Reservation reserverTerrain(ReservationKey reservation) {
        Reservation newRes = new Reservation();
        newRes.setTerrain(this.terrainRepo.findById(reservation.getTerrain_id()).orElseThrow(TerrainNotFoundException::new));
        newRes.setUtilisateur(this.utilisateurRepo.findById(reservation.getUtilisateur_id()).orElseThrow(UserNotFoundException::new));
        newRes.setId(reservation);
        return reservationRepo.save(newRes);
    }

}
