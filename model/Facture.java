package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class Facture implements Serializable{
    private static final long serialVersionUID = 1L;
    private List<Facture> factures;;
    
    private int idFacture;
    private Reservation reservation;
    private double prixChambre;
    private double prixRepas;
    private double total;

    // Constructeur
    public Facture(int idFacture, Reservation reservation, double prixChambre, double prixRepas, double total) {
        this.idFacture = idFacture;
        this.reservation = reservation;
        this.prixChambre = prixChambre;
        this.prixRepas = prixRepas;
        this.total = total;
    }

    // Getters
    public int getIdFacture() {
        return idFacture;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public double getPrixChambre() {
        return prixChambre;
    }

    public double getPrixRepas() {
        return prixRepas;
    }

    public double getTotal() {
        return total;
    }

    // Setters
    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void setPrixChambre(double prixChambre) {
        this.prixChambre = prixChambre;
    }

    public void setPrixRepas(double prixRepas) {
        this.prixRepas = prixRepas;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    // charger depuis fichier
    public void chargerFactures() {
        chargerListeDepuisFichier("facture.ser", factures);
    }

    // sauvegarder da s fichier
    public void sauvegarderFactures() {
        sauvegarderListeDansFichier(factures, "facture.ser");
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
