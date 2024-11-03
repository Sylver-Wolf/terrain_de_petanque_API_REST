package com.polytech.polytech.creationDTO;


public class UserCreationDTO {
        private String nom;
        private String prenom;
        private String mail;
        private String password;
        private String username;


        //Getter & Setter
        String getNom() {
            return nom;
        }
        void setNom(String nom) {
            this.nom = nom;
        }

        String getPrenom() {
            return prenom;
        }
        void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        String getMail() {
            return mail;
        }
        void setMail(String mail) {
            this.mail = mail;
        }

        String getPassword() {
            return password;
        }
        void setPassword(String password) {
            this.password = password;
        }

        String getUsername() {
            return username;
        }
        void setUsername(String username) {
            this.username = username;
        }
}

