package com.polytech.polytech.mapper;

import com.polytech.polytech.DTO.UserAccountDTO;
import com.polytech.polytech.DTO.UtilisateurDTO;
import com.polytech.polytech.entity.UserAccount;
import com.polytech.polytech.entity.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {


    Utilisateur toEntity(UtilisateurDTO User);

    UtilisateurDTO toDTO(Utilisateur User);

}

//le mapstruct implemente automatiquement cette interface