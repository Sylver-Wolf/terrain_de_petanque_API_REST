package com.polytech.polytech.controller;

import org.springframework.web.bind.annotation.*;
import com.polytech.polytech.entity.Utilisateur;

@RestController
@RequestMapping("")
public class UserController {

    @PostMapping("/CreateUser")
    public Utilisateur CreateUser(@RequestBody Utilisateur user) {
        Utilisateur createdUser = new Utilisateur();
        createdUser.setNom(user.getNom());
        createdUser.setPrenom(user.getPrenom());
        createdUser.setUsername(user.getUsername());
        createdUser.setPassword(user.getPassword());
        createdUser.setMail(user.getMail());
        return createdUser;
    }
}
