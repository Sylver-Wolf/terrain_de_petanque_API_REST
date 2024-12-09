package com.polytech.polytech.controller;


import com.polytech.polytech.DTO.TerrainDTO;
import com.polytech.polytech.DTO.UtilisateurDTO;
import com.polytech.polytech.entity.Terrain;
import com.polytech.polytech.entity.Utilisateur;
import com.polytech.polytech.mapper.TerrainMapper;
import com.polytech.polytech.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/terrain")
public class TerrainController {

    @Autowired
    private TerrainService terrainService;

    @Autowired
    private TerrainMapper terrainMapper;

    public TerrainController(TerrainService terrainService, TerrainMapper terrainMapper) {
        this.terrainService = terrainService;
        this.terrainMapper = terrainMapper;
    }

    @GetMapping
    public List<TerrainDTO> getAllTerrains() {
        List<Terrain> listOfTerrain = this.terrainService.getAllTerrains();
        List<TerrainDTO> listOfTerrainDTO = new ArrayList<>();
        for (Terrain t : listOfTerrain) {
            listOfTerrainDTO.add(this.terrainMapper.toDTO(t));
        }
        return listOfTerrainDTO;
    }

    @PostMapping
    public Terrain createTerrain(@RequestBody TerrainDTO terrainDTO) {
        return this.terrainService.createTerrain(this.terrainMapper.toEntity(terrainDTO));
    }

    @GetMapping("/{id}")
    public TerrainDTO getTerrainById(@PathVariable Integer id) {
        return this.terrainMapper.toDTO(this.terrainService.getTerrainById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteTerrain(@PathVariable Integer id) {
        this.terrainService.deleteTerrain(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TerrainDTO> updateTerrain(@PathVariable Integer id, @RequestBody TerrainDTO updatedTerrainDTO) {
        return ResponseEntity.ok(this.terrainMapper.toDTO(
                terrainService.updateTerrain(id, this.terrainMapper.toEntity(updatedTerrainDTO))));
    }


    //Autres méthodes

    /*
    @GetMapping("/{name}")
    public List<TerrainDTO> getTerrainByName(@PathVariable String name) {
        List<TerrainDTO> newTerrainDTO = new ArrayList<>();
        List<Terrain> terrainList = this.terrainService.getTerrainByName(name);
        for(Terrain u : terrainList) {
            newTerrainDTO.add(this.terrainMapper.toDTO(u));
        }
        return newTerrainDTO;
    }


     */
}


