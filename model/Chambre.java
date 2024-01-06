package model;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;


public class Chambre implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private int numeroChambre;
    private String typeChambre;
    private boolean disponible;
    private double prix;

    // Constructeur

    public Chambre(int numeroChambre, String typeChambre, boolean disponible, double prix) {
        this.numeroChambre = numeroChambre;
        this.typeChambre = typeChambre;
        this.disponible = disponible;
        this.prix = prix;
    }
     
    // constructeur sans parametres
    public Chambre(){

    }

    //getters
    public int getNumeroChambre() {
        return numeroChambre;
    }

    public String getTypeChambre() {
        return typeChambre;
    }

    public String getDisponible() {
        return disponible ? "Oui" : "Non";
    }

    public double getPrix() {
        return prix;
    } 
    
    
    
    //setters
    public void setNumeroChambre(int numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public void setTypeChambre(String typeChambre) {
        this.typeChambre = typeChambre;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }



    @Override
    public String toString() {
        return "{" +
            " numeroChambre='" + getNumeroChambre() + "'" +
            ", typeChambre='" + getTypeChambre() + "'" +
            ", disponible='" + getDisponible() + "'" +
            ", prix='" + getPrix() + "'" +
            "}";
    }

    protected  static void messageAfficheChambres() {
        System.out.println("voici la liste des chambres :");
        System.out.println("_________________________________________________________________________________________________________________________");
        
    }

    //  Methode qui affiche les elements de la chambre 
    protected static void AffichageChambre(Chambre chambre){
        System.out.print("Numero de chambre : " + chambre.getNumeroChambre()+", "); 
        System.out.print(" Type de chambre: " + chambre.getTypeChambre()+", ");
        System.out.print(" Disponible: " + chambre.getDisponible()+", ");
        System.out.println(" Prix: " + chambre.getPrix()+" euros");
        System.out.println(chambre);
        System.out.println("_________________________________________________________________________________________________________________________");
    }

    

    protected static <T extends Serializable> void chargerListeDepuisFichier(String nomFichier, List<T> liste) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomFichier))) {
            liste.clear();  // Efface la liste actuelle avant de charger
            List<T> listeChargee = (List<T>) ois.readObject();
            liste.addAll(listeChargee);
            System.out.println("Recuperation des données effectué avec succès !");
        } catch (IOException | ClassNotFoundException e) {
           System.err.println("Erreur lors du chargement de l'etat de l'hote : "+ e.getMessage());
            
        }
    }

    protected static <T extends Serializable> void sauvegarderListeDansFichier(List<T> liste, String nomFichier) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomFichier))) {
            oos.writeObject(liste);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde de l'état de l'hôtel : " + e.getMessage());
        }
    }

    
}