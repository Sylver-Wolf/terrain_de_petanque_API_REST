package com.polytech.polytech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.polytech.polytech.entity.Utilisateur;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur, Integer> {
}
