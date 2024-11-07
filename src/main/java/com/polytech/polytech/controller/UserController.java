package com.polytech.polytech.controller;


import com.polytech.polytech.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.polytech.polytech.entity.Utilisateur;

import java.util.List;

@RestController
@RequestMapping("")
public class UserController {
    //@Autowired
    private UtilisateurService userService;

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

    @GetMapping
    public List<Utilisateur> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Utilisateur getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public Utilisateur updateUser(@PathVariable Integer id, @RequestBody Utilisateur updatedUser) {
        return userService.updateUser(id, updatedUser);
    }



}
