package com.polytech.polytech.mapper;

import com.polytech.polytech.entity.Terrain;
import com.polytech.polytech.DTO.TerrainDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TerrainMapper {

    TerrainMapper instanceTerrainMapper = Mappers.getMapper(TerrainMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "quantite", target = "quantite")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "point_geo", target = "point_geo")
    Terrain toEntity(TerrainDTO terrain);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "quantite", target = "quantite")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "point_geo", target = "point_geo")
    TerrainDTO toDTO(Terrain terrain);
}
