package com.polytech.polytech.controller;


import com.polytech.polytech.DTO.UtilisateurDTO;
import com.polytech.polytech.entity.Utilisateur;
import com.polytech.polytech.mapper.UtilisateurMapper;
import com.polytech.polytech.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/utilisateur")
public class UserController {
    //Attributs

    @Autowired
    private UtilisateurService userService;


    //Constructeur
    public UserController(UtilisateurService userServiceParam) {
        this.userService = userServiceParam;
    }


    @PostMapping
    public Utilisateur createUser(@RequestBody UtilisateurDTO userDTO) {
        return this.userService.createUser(
                UtilisateurMapper.instanceUserMapper.toEntity(userDTO)
        );
    }

    @GetMapping
    public List<UtilisateurDTO> getAllUsers() {
        List<Utilisateur> listOfUser = this.userService.getAllUsers();
        List<UtilisateurDTO> listOfUserDTO = new ArrayList<>();
        for (Utilisateur u : listOfUser) {
            listOfUserDTO.add(UtilisateurMapper.instanceUserMapper.toDTO(u));
        }
        return listOfUserDTO;
    }

    @GetMapping("/{id}")
    public UtilisateurDTO getUserById(@PathVariable Integer id) {
        //if(this.userService.existingID()){
            return UtilisateurMapper.instanceUserMapper.toDTO(this.userService.getUserById(id));
        //}
        //return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public Utilisateur updateUser(@PathVariable Integer id, @RequestBody UtilisateurDTO updatedUserDTO) {
        return this.userService.updateUser(id, UtilisateurMapper.instanceUserMapper.toEntity(updatedUserDTO));
    }









}
