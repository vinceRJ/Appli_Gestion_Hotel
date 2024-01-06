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

public class Repas implements Serializable{
    private static final long serialVersionUID = 1L;
    private static List<Repas> listeDesRepas = new ArrayList<>();
    private static List<Repas> listeDesRepasCommande = new ArrayList<>();

   
    private String typeRepas;
    private String description;
    private double prixRepas;
    private Client clientQuiCommande;

    // Constructeur
    public Repas(String typeRepas, String description ,double prixRepas) {
     
        this.typeRepas = typeRepas;
        this.description = description;
        this.prixRepas = prixRepas;
    }

    // constructeur sans parametre
    public Repas() {
    }

    // Getters
    public String getTypeRepas() {
        return typeRepas;
    }

    public double getPrixRepas() {
        return prixRepas;
    }
    public String getDescription() {
        return description;
    }
    public String getClient(){
        return clientQuiCommande.getNom();
    }

    // Setters
    
    public void setTypeRepas(String typeRepas) {
        this.typeRepas = typeRepas;
    }

    public void setPrixRepas(double prixRepas) {
        this.prixRepas = prixRepas;
    }
    public void setClientDuiCommande(Client clientQuiCommande) {
        this.clientQuiCommande = clientQuiCommande;
    }
    
    
    // creer un repas
    public Repas creerRepas(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le type de repas : ");
        String typeRepas = scanner.nextLine();

        System.out.println("Entrez la description du repas : ");
        String description = scanner.nextLine();

        System.out.println("Entrez le prix du repas : ");
        double prixRepas = scanner.nextDouble();
        scanner.nextLine();

        Repas nouveauRepas = new Repas(typeRepas, description, prixRepas);
        // Ajoute le nouveau repas à la liste
        ajouterRepas(nouveauRepas);

        // Sauvegarde  repas
        sauvegarderRepas();

        return nouveauRepas;

    }

    // creation automatique de six repas
    
    public static void creerPlats() {
        Repas plat1 = new Repas("Déjeuner", "Délicieuses pâtes à la sauce tomate avec des herbes fraîches et du parmesan.", 15.99);
        Repas plat2 = new Repas("Dîner", "Steak grillé servi avec des légumes sautés et une purée de pommes de terre à l'ail.", 25.99);
        Repas plat3 = new Repas("Petit déjeuner", "Omelette aux champignons garnie de fromage et de fines herbes.", 12.99);
        Repas plat4 = new Repas("Dîner", "Pizza margherita avec une croûte fine, de la mozzarella fraîche et des tomates cerises.", 18.99);
        Repas plat5 = new Repas("Déjeuner", "Salade César fraîche avec des morceaux de poulet grillé, des croûtons et une vinaigrette crémeuse.", 14.99);
        Repas plat6 = new Repas("Petit déjeuner", "Pancakes moelleux servis avec des tranches de fruits frais et du sirop d'érable.", 10.99);

        ajouterRepas(plat1);
        ajouterRepas(plat2);
        ajouterRepas(plat3);
        ajouterRepas(plat4);
        ajouterRepas(plat5);
        ajouterRepas(plat6);

        sauvegarderRepas();
    }

    
    //liste des repas 
    public static void listeRepas(){

        System.out.println("Tous nos plats  sont :");
        System.out.println("_________________________________________________________________________________________________________________________");
        for (Repas plat : listeDesRepas) {
            System.out.println(" Type du plat : " + plat.getTypeRepas()+", ");
            System.out.println("Description : " + plat.getDescription());
            System.out.println(" Prix: " + plat.getPrixRepas()+", ");
           
        }
    }

    //liste des repas commande 
    public static void listeRepasCommander(){

        System.out.println("Tous les plats commande  sont :");
        int compteur = 1;
        for (Repas plat : listeDesRepasCommande) {
            System.out.print(" commande #"+ compteur + ". concerne le client : " + plat.getClient());
            System.out.println(" Type du plat : " + plat.getTypeRepas()+", ");
            System.out.println("Description : " + plat.getDescription());
            System.out.println(" Prix: " + plat.getPrixRepas()+", ");
            System.out.println("_________________________________________________________________________________________________________________________");
            compteur++;
           
        }
    }

    // choisir des repas 
    public static Repas choisirRepas() {
        Scanner scanner = new Scanner(System.in);
        chargerRepas();
        System.out.println("_________________________________________________________________________________________________________________________");
    
        System.out.println("Tous nos plats sont :");
        boolean test = true;
        while (test) {
            int compteur = 1;
            for (Repas plat : listeDesRepas) {
                System.out.print(compteur + ". ");
                System.out.print(" Type du plat : " + plat.getTypeRepas() + ", ");
                System.out.println("Description : " + plat.getDescription());
                System.out.println(" Prix: " + plat.getPrixRepas() + ", ");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------");
                compteur++;
            }
    
            System.out.print("Veuillez saisir le numéro du plat que vous souhaitez commander : \n=> ");
            int choixPlat = scanner.nextInt();
    
            if (choixPlat >= 1 && choixPlat <= compteur - 1) {
                test = false;
                // Retourne le repas choisi directement de la liste
                return listeDesRepas.get(choixPlat - 1);
            } else {
                System.out.println("Numéro de plat invalide. Veuillez réessayer.");
                continue;
            }
        }
        return null;  // Retourne null si aucune option valide n'est choisie
    }
    
    // repas commander 
    public static void commanderRepas(Client client, Repas repasServi) {
        
       
        repasServi.setClientDuiCommande(client);
        ajouterRepasCommander(repasServi);
        sauvegarderRepasCommander();
    }

    
    //ajout repas dans la liste des repas
    public static  void ajouterRepas(Repas leRepas) {
        listeDesRepas.add(leRepas);
    }
    //ajout repas commande dans la liste des repas commande
    public static  void ajouterRepasCommander(Repas leRepas) {
        listeDesRepasCommande.add(leRepas);
    }

    // charger repas
    public static void chargerRepas() {
        chargerListeDepuisFichier("repas.ser", listeDesRepas);
    }

    // charger repas commander
    public static void chargerRepasCommander() {
        chargerListeDepuisFichier("repascommande.ser", listeDesRepasCommande);
    }

    // sauvegarde repas
    public static void sauvegarderRepas() {
        sauvegarderListeDansFichier(listeDesRepas, "repas.ser");
    }
    // sauvegarde repas commander
    public static void sauvegarderRepasCommander() {
        sauvegarderListeDansFichier(listeDesRepasCommande, "repascommande.ser");
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
