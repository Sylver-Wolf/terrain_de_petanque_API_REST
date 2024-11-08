package com.polytech.polytech.mapper;

import com.polytech.polytech.DTO.UtilisateurDTO;
import com.polytech.polytech.entity.Utilisateur;
import org.apache.logging.log4j.CloseableThreadContext;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.Mapping;


@Mapper
public interface UtilisateurMapper {
    Utilisateur toEntity(UtilisateurDTO User);
    UtilisateurDTO toDTO(Utilisateur User);
}

//le mapstruct implemente automatiquement cette interface