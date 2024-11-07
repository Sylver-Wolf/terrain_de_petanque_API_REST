package com.polytech.polytech.controller;


import com.polytech.polytech.entity.Terrain;
import com.polytech.polytech.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("")
public class TerrainController {
    @Autowired
    private TerrainService terrainService;

    @GetMapping
    public List<Terrain> getAllTerrain() {
        return terrainService.getAllTerrains();
    }

    @PostMapping
    public Terrain createTerrain(@RequestBody Terrain terrain) {
        Terrain createdTerrain = new Terrain();
        createdTerrain.setDescription(terrain.getDescription());
        createdTerrain.setId(terrain.getId());
        createdTerrain.setNom(terrain.getNom());
        createdTerrain.setQuantite(terrain.getQuantite());
        createdTerrain.setPoint_geo(terrain.getPoint_geo());
        return createdTerrain;
    }

    @GetMapping("/{id}")
    public Terrain getAuteurById(@PathVariable Long id) {
        return terrainService.getTerrainById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAuteur(@PathVariable Long id) {
        terrainService.deleteTerrain(id);
    }

    @PutMapping("/{id}")
    public Terrain updateTerrain(@PathVariable Long id, @RequestBody Terrain updatedTerrain) {
        return terrainService.updateTerrain(id, updatedTerrain);
    }
}
