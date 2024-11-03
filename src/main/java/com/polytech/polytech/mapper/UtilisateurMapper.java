package com.polytech.polytech.mapper;

import com.polytech.polytech.DTO.UtilisateurDTO;
import com.polytech.polytech.entity.Utilisateur;
import org.mapstruct.Mapper;



@Mapper
public interface UtilisateurMapper {
    Utilisateur toEntity(UtilisateurDTO User);
    UtilisateurDTO toDTO(Utilisateur User);
}

//le mapstruct implemente automatiquement cette interface