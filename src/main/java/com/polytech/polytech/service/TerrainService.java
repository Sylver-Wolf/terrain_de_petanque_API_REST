package com.polytech.polytech.service;

import com.polytech.polytech.entity.Terrain;
import com.polytech.polytech.entity.Utilisateur;
import com.polytech.polytech.exception.NoTerrainInListException;
import com.polytech.polytech.exception.NoUserInListException;
import com.polytech.polytech.exception.TerrainNotFoundException;
import com.polytech.polytech.repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerrainService {
    @Autowired
    private TerrainRepository terrainRepository;

    public TerrainService(TerrainRepository terrainRepository) {
        this.terrainRepository = terrainRepository;
    }

    public List<Terrain> getAllTerrains() {
        if (terrainRepository.findAll().isEmpty()) {
            throw new NoTerrainInListException();
        }
        else {return terrainRepository.findAll();}
    }

    public Terrain getTerrainById(Integer id) {
        return terrainRepository.findById(id).orElseThrow(TerrainNotFoundException::new);
    }

    public Terrain createTerrain(Terrain terrain) {
        return terrainRepository.save(terrain);
    }

    public void deleteTerrain(Integer id) {
        if (!terrainRepository.existsById(id)) {
            throw new TerrainNotFoundException();
        }
        else {
        terrainRepository.deleteById(id);}
    }

    public Terrain updateTerrain(Integer id, Terrain updatedTerrain) {
        if(terrainRepository.existsById(id)) {
            Terrain existingTerrain = getTerrainById(id);
            existingTerrain.setNom(updatedTerrain.getNom());
            existingTerrain.setDescription(updatedTerrain.getDescription());
            existingTerrain.setQuantite(updatedTerrain.getQuantite());
            existingTerrain.setPoint_geo(updatedTerrain.getPoint_geo());
            return terrainRepository.save(existingTerrain);
        }
        else {throw new TerrainNotFoundException();}
    }

    //Other methods

    public List<Terrain> getTerrainByName(String name) {
        if(terrainRepository.findAll().isEmpty()) {
            throw (new NoUserInListException());
        }
        else return terrainRepository.findByName(name).orElse(null);
    }

    



}
