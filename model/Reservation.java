package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Reservation implements Serializable{
    private static final long serialVersionUID = 1L;
    public static List<Reservation> reservations = new ArrayList<>();
    
    
    private int idReservation;
    private Client client;
    public Chambre chambre;
    private String dateDebut;
    private String dateFin;

    // Constructeur
    public Reservation(Client client, Chambre chambre, String dateDebut, String dateFin) {
        this.idReservation = 1;
        this.client = client;
        this.chambre = chambre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;

        this.idReservation ++;
    }

    // construteur sans parametre
    public Reservation(){

    }

    // Getters
    public int getIdReservation() {
        return idReservation;
    }

    public Client getClient() {
        return client;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    // Setters
   

    public void setClient(Client client) {
        this.client = client;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }



    @Override
    public String toString() {
        return "{" +
            " idReservation='" + getIdReservation() + "'" +
            ", client='" + getClient() + "'" +
            ", chambre='" + getChambre() + "'" +
            ", dateDebut='" + getDateDebut() + "'" +
            ", dateFin='" + getDateFin() + "'" +
            "}";
    }

    // ajout de la reservation dans la liste 
    public static void ajouterReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void sauvegarderModification() {
        // Supprimer l'ancienne réservation de la liste
        reservations.remove(this);
        // Ajout de la réservation modifiée à la liste
        reservations.add(this);
        // Sauvegarder la liste mise à jour dans le fichier 
        sauvegarderReservation();
    }


    //// sauvegarde  dans le fichier
    public static void sauvegarderReservation(){
        sauvegarderListeDansFichier(reservations, "reservations.ser");
        System.out.println("la Reservation a bien été sauvegardé avec succès.");
    }


    public void chargerReservations() {
        chargerListeDepuisFichier("reservations.ser", reservations);
    }

    private static <T extends Serializable> void sauvegarderListeDansFichier(List<T> liste, String nomFichier) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomFichier))) {
            oos.writeObject(liste);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde de l'état de l'hôtel : " + e.getMessage());
        }
    }

    private <T extends Serializable> void chargerListeDepuisFichier(String nomFichier, List<T> liste) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomFichier))) {
            liste.clear();  // Efface la liste actuelle avant de charger
            List<T> listeChargee = (List<T>) ois.readObject();
            liste.addAll(listeChargee);
            System.out.println("L'etat de l'hotel chargee avec succès !");
        } catch (IOException | ClassNotFoundException e) {
           System.err.println("Erreur lors du chargement de l'etat de l'hote : "+ e.getMessage());
            
        }
    }

}
