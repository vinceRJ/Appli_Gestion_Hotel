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


public class Client implements Serializable{
    private static final long serialVersionUID = 1L;
    private static List<Client> clients = new ArrayList<>();

   
    private String nom;
    private String prenom;
    private String adresse;
    private String numeroTel;

    // Constructeur
    public Client(String nom, String prenom, String adresse, String numeroTel) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numeroTel = numeroTel;
    }
    // construteur sans parametres
    public Client() {
    }

    // Getters
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

    public Client creerClient() {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le nom du client : ");
        String nom = scanner.nextLine();

        System.out.println("Entrez le prénom du client : ");
        String prenom = scanner.nextLine();

        System.out.println("Entrez l'adresse du client : ");
        String adresse = scanner.nextLine();

        System.out.println("Entrez le numéro de téléphone du client : ");
        String numeroTel = scanner.nextLine();

             
        // Crée une nouvelle instance de Client
        Client client = new Client(nom, prenom, adresse, numeroTel);

        // Ajout du client  à la liste
        ajouterClient(client);

        //sauvegarde le client
        sauvegarderClients();

        //retourne une nouvelle instance de Client
        
        return client;
    }
    // Ajout du client  à la liste client
    private  void ajouterClient(Client client) {
        clients.add(client);
    }

    // sauvegarde client dans le fichier
     public  void sauvegarderClients() {
        sauvegarderListeDansFichier(clients, "clients.ser");
        System.out.println("le Client a bien été sauvegardé avec succès.");
    }
    
    // recupere les clients sauvegarde dans le fichier
    public static void chargerClients() {
        chargerListeDepuisFichier("clients.ser", clients);
    }

    // liste de client
    public static  void listeClient(){
        System.out.println("Tous nos client  sont :");
        System.out.println("_________________________________________________________________________________________________________________________");
        for (Client client : clients) {
            System.out.print(" Nom : " + client.getNom()+", ");
            System.out.print(" Prenom: " + client.getPrenom()+", ");
            System.out.print(" Numero: " + client.getNumeroTel()+", ");
            System.out.println(" adresse : " + client.getAdresse()+", ");
        }
    }

    private static <T extends Serializable> void chargerListeDepuisFichier(String nomFichier, List<T> liste) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomFichier))) {
            liste.clear();  // Efface la liste actuelle avant de charger
            List<T> listeChargee = (List<T>) ois.readObject();
            liste.addAll(listeChargee);
            System.out.println("Recuperation des données effectué avec succès !");
        } catch (IOException | ClassNotFoundException e) {
           System.err.println("Erreur lors du chargement de l'etat de l'hote : "+ e.getMessage());
            
        }
    }

    private static <T extends Serializable> void sauvegarderListeDansFichier(List<T> liste, String nomFichier) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomFichier))) {
            oos.writeObject(liste);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde de l'état de l'hôtel : " + e.getMessage());
        }
    }
}
