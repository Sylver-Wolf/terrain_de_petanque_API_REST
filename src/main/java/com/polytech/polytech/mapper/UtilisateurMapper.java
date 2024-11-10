package com.polytech.polytech.mapper;

import com.polytech.polytech.DTO.UtilisateurDTO;
import com.polytech.polytech.entity.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "prenom", target = "prenom")
    @Mapping(source = "mail", target = "mail")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "username", target = "username")
    Utilisateur toEntity(UtilisateurDTO User);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "prenom", target = "prenom")
    @Mapping(source = "mail", target = "mail")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "username", target = "username")
    UtilisateurDTO toDTO(Utilisateur User);
}

//le mapstruct implemente automatiquement cette interface