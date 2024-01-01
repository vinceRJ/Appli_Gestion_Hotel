package model;


import java.io.Serializable;

public class Client implements Serializable{
    private static final long serialVersionUID = 1L;


    private int idClient;
    private String nom;
    private String prenom;
    private String adresse;

    // Constructeur
    public Client(int idClient, String nom, String prenom, String adresse) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
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
}
