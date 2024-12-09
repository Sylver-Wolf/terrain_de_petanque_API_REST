package com.polytech.polytech.controller;


import com.polytech.polytech.DTO.UtilisateurDTO;
import com.polytech.polytech.entity.Utilisateur;
import com.polytech.polytech.mapper.UtilisateurMapper;
import com.polytech.polytech.service.UtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Slf4j

@RestController
@RequestMapping("/api/utilisateur")
public class UserController {
    //Attributs

    @Autowired
    private UtilisateurService userService;

    @Autowired
    private UtilisateurMapper userMapper;


    //Constructeur
    public UserController(UtilisateurService userServiceParam, UtilisateurMapper userMapperParam) {
        this.userService = userServiceParam;
        this.userMapper = userMapperParam;
    }

    //Partie CRUD
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UtilisateurDTO> createUser(@RequestBody() UtilisateurDTO userDTO) {
        return ResponseEntity.ok(this.userMapper.toDTO(
                this.userService.createUser(this.userMapper.toEntity(userDTO))));
    }

    @GetMapping
    public List<UtilisateurDTO> getAllUsers() {
        List<Utilisateur> listOfUser = this.userService.getAllUsers();
        List<UtilisateurDTO> listOfUserDTO = new ArrayList<>();
        for (Utilisateur u : listOfUser) {
            listOfUserDTO.add(this.userMapper.toDTO(u));
        }
        return listOfUserDTO;
    }

    @GetMapping("/userID/{id}")
    public UtilisateurDTO getUserById(@PathVariable Integer id) {
            return userMapper.toDTO(this.userService.getUserById(id));
    }

    @GetMapping("/username/{nom}")
    public ResponseEntity<UtilisateurDTO> getUserByNom(@PathVariable String nom) {
        return ResponseEntity.ok(
                userMapper.toDTO(
                        this.userService.getUserByName(nom)));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        this.userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UtilisateurDTO> updateUser(@PathVariable Integer id, @RequestBody UtilisateurDTO updatedUserDTO) {
        return ResponseEntity.ok(this.userMapper.toDTO(this.userService.updateUser(id, this.userMapper.toEntity(updatedUserDTO))));
    }



    //Méthodes supplémentaire






}
