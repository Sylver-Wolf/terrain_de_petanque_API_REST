package com.polytech.polytech.service;
import com.polytech.polytech.entity.Utilisateur;
import com.polytech.polytech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//@Autowired
public class UtilisateurService {

    private UserRepository userRepository;

    public List<Utilisateur> getAllUsers() {
        return userRepository.findAll();
    }

    public Utilisateur createUser(Utilisateur user) {
        return userRepository.save(user);
    }

    public Utilisateur getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public Utilisateur updateUser(Integer id, Utilisateur updatedUser) {
        Utilisateur existingUser = getUserById(id);
        if(existingUser != null) {
            existingUser.setNom(updatedUser.getNom());
            existingUser.setPrenom(updatedUser.getPrenom());
            existingUser.setMail(updatedUser.getMail());
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(updatedUser.getPassword());
            return userRepository.save(existingUser);
        }
        return null;
    }
}
