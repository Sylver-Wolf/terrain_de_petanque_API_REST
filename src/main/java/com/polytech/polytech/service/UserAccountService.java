package com.polytech.polytech.service;

import com.polytech.polytech.entity.UserAccount;
import com.polytech.polytech.entity.Utilisateur;
import com.polytech.polytech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

    @Autowired
    private UserRepository userRepository;



    public Integer checkUser(UserAccount userAccount) {
        Utilisateur userToCheck = this.userRepository.findByName(userAccount.getUsername()).orElse(null);
        if (userToCheck == null || (!userToCheck.getPassword().equals(userAccount.getPassword()))) {
            return null;

        }
        return userToCheck.getId();
    }

}
