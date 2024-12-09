package com.polytech.polytech.service;
import com.polytech.polytech.entity.Terrain;
import com.polytech.polytech.entity.Utilisateur;
import com.polytech.polytech.exception.NoUserInListException;
import com.polytech.polytech.exception.UserNotFoundException;
import com.polytech.polytech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
    @Autowired
    private UserRepository userRepository;

    public List<Utilisateur> getAllUsers() {
        if(userRepository.findAll().isEmpty()) {
            throw (new NoUserInListException());
        } else {
            return userRepository.findAll();
        }
    }

    public Utilisateur createUser(Utilisateur user) {
        return userRepository.save(user);
    }

    public Utilisateur getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public Utilisateur getUserByName(String name) {
        if(userRepository.findAll().isEmpty()) {
            throw (new NoUserInListException());
        }
        else return userRepository.findByName(name);
        }


    public void deleteUser(Integer id) {
        if(userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw (new UserNotFoundException());
        }
    }

    public Utilisateur updateUser(Integer id, Utilisateur updatedUser) {
        if(userRepository.findById(id).isPresent()) {
            Utilisateur existingUser = getUserById(id);
            existingUser.setNom(updatedUser.getNom());
            existingUser.setPrenom(updatedUser.getPrenom());
            existingUser.setMail(updatedUser.getMail());
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(updatedUser.getPassword());
            return userRepository.save(existingUser);
        } else {
            throw (new UserNotFoundException());
        }
    }
}
