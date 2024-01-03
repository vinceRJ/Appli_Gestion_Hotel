package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class Repas implements Serializable{
    private static final long serialVersionUID = 1L;
    private List<Repas> repas;

    private int idRepas;
    private Client client;
    private String typeRepas;
    private double prixRepas;

    // Constructeur
    public Repas(int idRepas, Client client, String typeRepas, double prixRepas) {
        this.idRepas = idRepas;
        this.client = client;
        this.typeRepas = typeRepas;
        this.prixRepas = prixRepas;
    }

    // Getters
    public int getIdRepas() {
        return idRepas;
    }

    public Client getClient() {
        return client;
    }

    public String getTypeRepas() {
        return typeRepas;
    }

    public double getPrixRepas() {
        return prixRepas;
    }

    // Setters
    public void setIdRepas(int idRepas) {
        this.idRepas = idRepas;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setTypeRepas(String typeRepas) {
        this.typeRepas = typeRepas;
    }

    public void setPrixRepas(double prixRepas) {
        this.prixRepas = prixRepas;
    }
    


    // charger repas
    public void chargerRepas() {
        chargerListeDepuisFichier("repas.ser", repas);
    }

    // sauvegarde repas
    public void sauvegarderRepas() {
        sauvegarderListeDansFichier(repas, "repas.ser");
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
