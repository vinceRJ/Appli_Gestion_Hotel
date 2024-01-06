package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Reservation implements Serializable{
    private static final long serialVersionUID = 1L;
    public static List<Reservation> laListeDesReservations = new ArrayList<>();
    
    
    private int idReservation = 1;
    private Client client;
    public Chambre chambre;
    private String dateDebut;
    private String dateFin;

    // Constructeur
    public Reservation(Client client, Chambre chambre, String dateDebut, String dateFin) {
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
        this.idReservation = 1;
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

    // afficher liste des reservations
    public static void afficherReservation() {
        chargerReservations();
        System.out.println("Les reservation sont :");
        System.out.println("_________________________________________________________________________________________________________________________");
        for (Reservation reservation : laListeDesReservations) {
            affichageReservation(reservation);
        }
    }

    public static Reservation ChoixReservation(){
        Reservation reservationChoisie = new Reservation();
        Scanner scanner = new Scanner(System.in);
        chargerReservations();
        boolean test = true;
        while (test) {
            int compteur = 1;
            System.out.println("Les reservation sont :");
            System.out.println("_________________________________________________________________________________________________________________________");
            for (Reservation reservation : laListeDesReservations) {
                System.out.print(compteur + ". ");
                affichageReservation(reservation);
                compteur++;
            }
            System.out.print("Choisissez le numéro de la reservation que vous souhaitez modifier :\n=> ");
            int numeroChoisi = scanner.nextInt();
            if (numeroChoisi > 0 && numeroChoisi<= compteur - 1) {
                reservationChoisie  = laListeDesReservations.get(numeroChoisi -1);
                test = false;
                return reservationChoisie;
            }
            else {
                System.out.println("Aucune reservation sélectionnée.");
                continue;
            }
        }
        return null;
    }


    // afficher une reservation
    public static String affichageReservation(Reservation reservation) {
        System.out.println("Réservation #" + reservation.getIdReservation());
        System.out.println("Client : " + reservation.getClient().getNom() + " - " + reservation.getClient().getPrenom() +" Numero Telephone = " + reservation.getClient().getNumeroTel());
        System.out.println("Chambre reservée : " + reservation.getChambre().getNumeroChambre() + " - " + reservation.getChambre().getTypeChambre());
        System.out.println("Dates du séjour : " + reservation.getDateDebut() + " au " + reservation.getDateFin());
        return null;

    }
    // date de Debut reservation
    public static String demanderDateDebut() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez la date de début du séjour (format dd/MM/yyyy) : ");
        String dateDebut = scanner.next();
    
        if (dateDebut.isEmpty()) {
            System.out.println("Veuillez saisir une date de début valide.");
            return null;
        }
    
        return dateDebut;
    }

    // date de fin reservation
    public static String demanderDateFin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez la date de fin du séjour (format dd/MM/yyyy) : ");
        String dateFin = scanner.next();
    
        if (dateFin.isEmpty()) {
            System.out.println("Veuillez saisir une date de fin valide.");
            return null;
        }
    
        return dateFin;
    }

    // ajout de la reservation dans la liste 
    public static void ajouterReservation(Reservation reservation) {
        laListeDesReservations.add(reservation);
    }

    public void sauvegarderModification() {
        // Supprimer l'ancienne réservation de la liste
        laListeDesReservations.remove(this);
        // Ajout de la réservation modifiée à la liste
        laListeDesReservations.add(this);
        // Sauvegarder la liste mise à jour dans le fichier 
        sauvegarderReservation();
    }


    //// sauvegarde  dans le fichier
    public static void sauvegarderReservation(){
        sauvegarderListeDansFichier(laListeDesReservations, "reservations.ser");
        System.out.println("la Reservation a bien été sauvegardé avec succès.");
    }


    public static void chargerReservations() {
        chargerListeDepuisFichier("reservations.ser", laListeDesReservations);
    }

    private static <T extends Serializable> void sauvegarderListeDansFichier(List<T> liste, String nomFichier) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomFichier))) {
            oos.writeObject(liste);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde de l'état de l'hôtel : " + e.getMessage());
        }
    }

    private static <T extends Serializable> void chargerListeDepuisFichier(String nomFichier, List<T> liste) {
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
