package com.polytech.polytech.service;

import com.polytech.polytech.entity.Terrain;
import com.polytech.polytech.repository.TerrainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerrainService {
    //@Autowired
    private TerrainRepository terrainRepository;

    public TerrainService(TerrainRepository terrainRepository) {
        this.terrainRepository = terrainRepository;
    }

    public List<Terrain> getAllTerrains() {
        return terrainRepository.findAll();
    }

    public Terrain getTerrainById(Integer id) {
        return terrainRepository.findById(id).orElse(null);
    }

    public Terrain createTerrain(Terrain terrain) {
        return terrainRepository.save(terrain);
    }

    public void deleteTerrain(Integer id) {
        terrainRepository.deleteById(id);
    }

    public Terrain updateTerrain(Integer id, Terrain updatedTerrain) {
        Terrain existingTerrain = getTerrainById(id);
        if(existingTerrain != null) {
            existingTerrain.setNom(updatedTerrain.getNom());
            existingTerrain.setDescription(updatedTerrain.getDescription());
            existingTerrain.setQuantite(updatedTerrain.getQuantite());
            existingTerrain.setPoint_geo(updatedTerrain.getPoint_geo());
            return terrainRepository.save(existingTerrain);
        }
        return null;
    }
}
