package com.polytech.polytech.repository;

import com.polytech.polytech.entity.Reservation;
import com.polytech.polytech.entity.ReservationKey;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, ReservationKey> {
}
