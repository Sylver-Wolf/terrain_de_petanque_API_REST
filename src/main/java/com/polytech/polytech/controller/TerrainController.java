package com.polytech.polytech.controller;


import com.polytech.polytech.entity.Terrain;
import com.polytech.polytech.repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TerrainController {
    @Autowired
    private TerrainRepository terrainRepository;
    @GetMapping
    public List<Terrain> getAllAuteurs() {
        return terrainRepository.findAll();
    }
    @PostMapping
    public Terrain createTerrain(@RequestBody Terrain terrain) {
        Terrain createdTerrain = new Terrain();
        return createdTerrain;
    }
}
