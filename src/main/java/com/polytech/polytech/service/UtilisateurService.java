package com.polytech.polytech.service;

import com.polytech.polytech.entity.Utilisateur;
import com.polytech.polytech.exception.UserNotFoundException;
import com.polytech.polytech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UserRepository userRepository;

    public UtilisateurService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Utilisateur> getAllUsers() {
        return userRepository.findAll();
    }


    public Utilisateur getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
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

    public Utilisateur createUser(Utilisateur newUser) {
        return userRepository.save(newUser);
    }
}
