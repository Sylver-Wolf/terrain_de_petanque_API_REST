package com.polytech.polytech.controller;


import com.polytech.polytech.DTO.TerrainDTO;
import com.polytech.polytech.entity.Terrain;
import com.polytech.polytech.mapper.TerrainMapper;
import com.polytech.polytech.service.TerrainService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/terrain")
public class TerrainController {

    private TerrainService terrainService;

    public TerrainController(TerrainService terrainService) {
        this.terrainService = terrainService;
    }

    @GetMapping
    public List<TerrainDTO> getAllTerrains() {
        List<Terrain> listOfTerrain = this.terrainService.getAllTerrains();
        List<TerrainDTO> listOfTerrainDTO = new ArrayList<>();
        for (Terrain t : listOfTerrain) {
            listOfTerrainDTO.add(TerrainMapper.instanceTerrainMapper.toDTO(t));
        }
        return listOfTerrainDTO;
    }

    @PostMapping
    public Terrain createTerrain(@RequestBody TerrainDTO terrainDTO) {
        return this.terrainService.createTerrain(TerrainMapper.instanceTerrainMapper.toEntity(terrainDTO));
    }

    @GetMapping("/{id}")
    public TerrainDTO getTerrainById(@PathVariable Integer id) {
        return TerrainMapper.instanceTerrainMapper.toDTO(this.terrainService.getTerrainById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteTerrain(@PathVariable Integer id) {
        this.terrainService.deleteTerrain(id);
    }

    @PutMapping("/{id}")
    public Terrain updateTerrain(@PathVariable Integer id, @RequestBody TerrainDTO updatedTerrainDTO) {
        return terrainService.updateTerrain(id, TerrainMapper.instanceTerrainMapper.toEntity(updatedTerrainDTO));
    }

}
