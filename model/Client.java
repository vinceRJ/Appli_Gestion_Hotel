package model;

import java.io.Serializable;


public class Client implements Serializable{
    private static final long serialVersionUID = 1L;

    private int idClient;
    private String nom;
    private String prenom;
    private String adresse;
    private String numeroTel;

    // Constructeur
    public Client(int idClient, String nom, String prenom, String adresse, String numeroTel) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numeroTel = numeroTel;
    }

    // Getters
    public int getIdClient() {
        return idClient;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    // Setters
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNumeroTel(String numeroTel){
        this.numeroTel = numeroTel;
    }

}
