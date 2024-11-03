package com.polytech.polytech.mapper;

import com.polytech.polytech.entity.Terrain;
import com.polytech.polytech.DTO.TerrainDTO;

import org.mapstruct.Mapper;

@Mapper
public interface TerrainMapper {
    Terrain toEntity(TerrainDTO terrain);
    TerrainDTO toDTO(Terrain terrain);
}
