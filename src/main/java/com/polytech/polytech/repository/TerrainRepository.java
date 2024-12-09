package com.polytech.polytech.repository;

import com.polytech.polytech.entity.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Integer> {
}
