package com.polytech.polytech.mapper;


import com.polytech.polytech.DTO.ReservationDTO;
import com.polytech.polytech.entity.Reservation;
import org.mapstruct.Mapper;

@Mapper
public interface ReservationMapper {
    Reservation toEntity(ReservationDTO Resa);
    ReservationDTO toDTO(Reservation Resa);
}
