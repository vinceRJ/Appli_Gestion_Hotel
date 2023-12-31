// Classe responsable de la coordination
//La classe HotelController est responsable de la gestion 
//du flux de contrôle, de la logique d'affichage, et de 
//la coordination des actions entre la vue et le modèle. 
//Cela contribue à une meilleure séparation des préoccupations 
//et à une structure 

package controller;

import java.util.Scanner;
import model.Client;
import model.Chambre;
import model.Reservation;
import model.Repas;
import model.Facture;
import java.util.Scanner;




public class HotelController {
    private final Scanner scanner;

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

    private void afficherDetailsChambres() {
        // Logique pour afficher les détails des chambres
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
}
