// Classe responsable de la coordination
//La classe HotelController est responsable de la gestion 
//du flux de contrôle, de la logique d'affichage, et de 
//la coordination des actions entre la vue et le modèle. 
//Cela contribue à une meilleure séparation des préoccupations 
//et à une structure 

package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Client;
import model.Chambre;
import model.ChambreDeLuxe;
import model.ChambreNormale;
import model.Reservation;
import model.Repas;
import model.Facture;
import java.io.*;
import java.sql.Array;





public class HotelController {
    private final Scanner scanner;

    private List<Reservation> reservation;
    private List<Repas> repas;
    private List<Facture> factures;
    private List<Client> clients;
    private List<ChambreNormale> chambreNormale = new ArrayList<>();
    private List<ChambreDeLuxe> chambreDeLuxe = new ArrayList<>();
    private List<Chambre> chambre;

    public HotelController() {
        this.scanner = new Scanner(System.in);
        // Initialisations supplémentaires si nécessaires
    }

    public void afficherMenuPrincipal() {
        int choix;
        do {
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Afficher les détails des chambres");
            System.out.println("2. Afficher la disponibilité des chambres");
            System.out.println("3. Effectuer une réservation");
            System.out.println("4. Modifier une réservation");
            System.out.println("5. Annuler une réservation");
            System.out.println("6. Commander un repas");
            System.out.println("7. Enregistrer la facture");
            System.out.println("8. Quitter");
            System.out.print("Choisissez une option : ");

            choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne après la saisie du choix

            traiterChoixMenuPrincipal(choix);
        } while (choix != 8);
    }

    private void traiterChoixMenuPrincipal(int choix) {
        switch (choix) {
            case 1:
                afficherDetailsChambres();
                break;
            case 2:
                afficherDisponibilitesChambres();
                break;
            case 3:
                effectuerReservation();
                break;
            case 4:
                modifierReservation();
                break;
            case 5:
                annulerReservation();
                break;
            case 6:
                commanderRepas();
                break;
            case 7:
                enregistrerFacture();
                break;
            case 8:
                System.out.println("Au revoir !");
                break;
            default:
                System.out.println("Option non valide. Veuillez réessayer.");
        }
    }

    // Ajoutez les autres méthodes spécifiques de contrôle ici
    // (afficherDetailsChambres, afficherDisponibilitesChambres, etc.)

    public void afficherDetailsChambres() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Choisissez le type de chambre à afficher :");
        System.out.println("1. Chambre de luxe ");
        System.out.println("2. Chambre Normaux");

        int choix = scanner.nextInt();

        switch (choix) {
            case 1:
                afficherChambresDeLuxe();
                break;
            case 2:
                afficherChambresNormales();
                break;
            default:
                System.out.println("Votre choix est invalide");
        }
    }

    private void afficherChambresDeLuxe() {
        System.out.println("Les Chambres de Luxe :");
        System.out.println("_________________________________________________________________________________________________________________________");
        for (ChambreDeLuxe chambre : chambreDeLuxe) {
            System.out.print("Numero de chambre : " + chambre.getNumeroChambre()+", "); 
            System.out.print(" Type de chambre: " + chambre.getTypeChambre()+", ");
            System.out.print(" Disponible: " + chambre.getDisponible()+", ");
            System.out.println(" Prix: " + chambre.getPrix()+"euros");
            System.out.println(chambre);
            System.out.println("_________________________________________________________________________________________________________________________");

            
        }
    }

    private void afficherChambresNormales() {
        System.out.println("Les Chambres Normaux :");
        System.out.println("_________________________________________________________________________________________________________________________");
        for (ChambreNormale chambre : chambreNormale) {
            System.out.print("Numero de chambre : " + chambre.getNumeroChambre()+", "); 
            System.out.print(" Type de chambre: " + chambre.getTypeChambre()+", ");
            System.out.print(" Disponible: " + chambre.getDisponible()+", ");
            System.out.println(" Prix: " + chambre.getPrix()+"euros");
            System.out.println(chambre);
            System.out.println("_________________________________________________________________________________________________________________________");
            
        }
    }


    private void afficherDisponibilitesChambres() {
        // Logique pour afficher la disponibilité des chambres
    }

    private void effectuerReservation() {
        // Logique pour effectuer une réservation
    }

    private void modifierReservation() {
        // Logique pour modifier une réservation
    }

    private void annulerReservation() {
        // Logique pour annuler une réservation
    }

    private void commanderRepas() {
        // Logique pour commander un repas
    }

    private void enregistrerFacture() {
        // Logique pour enregistrer la facture
    }






    // les methodes pour sauvegarder l'etat de l'hotel dans un fichier


    public void sauvegarderReservation(){
        sauvegarderListeDansFichier(reservation, "reservations.ser");
    }

    public void sauvegarderClients() {
        sauvegarderListeDansFichier(clients, "clients.ser");
    }

    public void sauvegarderRepas() {
        sauvegarderListeDansFichier(repas, "repas.ser");
    }

    public void sauvegarderFactures() {
        sauvegarderListeDansFichier(factures, "facture.ser");
    }

    public void sauvegarderChambreNormale() {
        sauvegarderListeDansFichier(chambreNormale, "chambreNormal.ser");
    }

    public void sauvegarderChambreDeLuxe() {
        sauvegarderListeDansFichier(chambreDeLuxe, "chambreDeLuxe.ser");
    }
    
    private <T extends Serializable> void sauvegarderListeDansFichier(List<T> liste, String nomFichier) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomFichier))) {
            oos.writeObject(liste);
            System.out.println("État de l'hôtel a bien été sauvegardé avec succès.");
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde de l'état de l'hôtel : " + e.getMessage());
        }
    }

    //  Méthode pour charger l'état de l'hôtel depuis un fichier


    public void chargerReservations() {
        chargerListeDepuisFichier("reservations.ser", reservation);
    }

    public void chargerChambreNormal() {
        chargerListeDepuisFichier("chambreNormal.ser", chambreNormale);
    }

    public void chargerChambreDeLuxe() {
        chargerListeDepuisFichier("chambreDeLuxe.ser", chambreDeLuxe);
    }

    public void chargerClients() {
        chargerListeDepuisFichier("clients.ser", clients);
    }

    public void chargerRepas() {
        chargerListeDepuisFichier("repas.ser", repas);
    }

    public void chargerFactures() {
        chargerListeDepuisFichier("facture.ser", factures);
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




////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// ========================CREATION DES CHAMBRE ============================    

    public void creerChambreDeLuxe(){
        //chambreDeLuxe = new ArrayList();
        // Création de chambres de luxe

        ChambreDeLuxe chambre1 = new ChambreDeLuxe(101, true, 200.0, new String[]{"Wi-Fi", "Service en chambre"}, true, false, true);
        ChambreDeLuxe chambre2 = new ChambreDeLuxe(102, false, 250.0, new String[]{"Spa privé", "Petit-déjeuner inclus"}, false, true, false);
        ChambreDeLuxe chambre3 = new ChambreDeLuxe(103, true, 220.0, new String[]{"Service de blanchisserie", "Parking gratuit"}, true, true, false);
        ChambreDeLuxe chambre4 = new ChambreDeLuxe(104, false, 280.0, new String[]{"Repas gastronomique", "Vue panoramique"}, false, false, true);
        ChambreDeLuxe chambre5 = new ChambreDeLuxe(105, true, 230.0, new String[]{"Service de conciergerie", "Navette aéroport"}, true, false, false);


        // Ajout des chambres à la liste
        chambreDeLuxe.add(chambre1);
        chambreDeLuxe.add(chambre2);
        chambreDeLuxe.add(chambre3);
        chambreDeLuxe.add(chambre4);
        chambreDeLuxe.add(chambre5);

        // Sauvergade des chambres créés dans le fichier correspondant
        sauvegarderChambreDeLuxe();


    
    }
    
    public void creerChambreNormal(){
        //chambreNormale = new ArrayList();
        // Création de chambres de luxe

        ChambreNormale chambre1 = new ChambreNormale(201, true, 120.0, new String[]{"Wi-Fi", "Climatisation"}, true, true, false);
        ChambreNormale chambre2 = new ChambreNormale(202, false, 150.0, new String[]{"Service en chambre", "Parking gratuit"}, false, false, true);
        ChambreNormale chambre3 = new ChambreNormale(203, true, 130.0, new String[]{"Petit-déjeuner inclus", "Service de blanchisserie"}, true, false, true);
        ChambreNormale chambre4 = new ChambreNormale(204, false, 160.0, new String[]{"Vue sur le jardin", "Repas léger disponible"}, false, true, false);
        ChambreNormale chambre5 = new ChambreNormale(205, true, 140.0, new String[]{"Navette gratuite", "Accès à la salle de sport"}, false, true, false);



        // Ajout des chambres à la liste
        chambreNormale.add(chambre1);
        chambreNormale.add(chambre2);
        chambreNormale.add(chambre3);
        chambreNormale.add(chambre4);
        chambreNormale.add(chambre5);

        // Sauvergade des chambres créés dans le fichier correspondant
        sauvegarderChambreNormale();
    
    }
//================================FIN DE LA CREATION ================================




}
