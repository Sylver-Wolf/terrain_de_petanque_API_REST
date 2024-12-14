package com.polytech.polytech.mapper;


import com.polytech.polytech.DTO.ReservationDTO;
import com.polytech.polytech.entity.Reservation;
import com.polytech.polytech.entity.ReservationKey;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    //@Mapping(source = "reservation", target = "reservation")
    Reservation toEntity(ReservationDTO Resa);

    //@Mapping(source = "reservation", target = "reservation")
    ReservationDTO toDTO(Reservation Resa);

}
