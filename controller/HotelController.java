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
import model.ChambreDeLuxe;
import model.ChambreNormale;
import model.Reservation;
import model.Repas;
import model.Reservable;
import model.Facture;
import java.io.*;




public class HotelController {
    private final Scanner scanner;
        
    private Client newClient;
    private ChambreDeLuxe newChambreDeLuxe;
    private ChambreNormale newChambreNormale;

    public HotelController() {
        this.scanner = new Scanner(System.in);
        this.newClient = new Client();
        this.newChambreDeLuxe = new ChambreDeLuxe();
        this.newChambreNormale = new ChambreNormale();

        // Initialisations supplémentaires  tel ajouter des chambres ou des repas ou reservation
    }

    public void afficherMenuPrincipal() {
        int choix;
        do {
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Les chambres");
            System.out.println("2. Effectuer une réservation (en cours d'implementation)");
            System.out.println("3. Modifier une réservation (pas encore implementé)");
            System.out.println("4. Annuler une réservation (pas encore implementé)");
            System.out.println("5. Commander un repas (pas encore implementé)");  // TAFF Ornel
            System.out.println("6. Enregistrer la facture (pas encore implementé)");
            System.out.println("7. Options  client ");
            System.out.println("8. Options  repas "); // TAFF Ornel
            System.out.println("9. Quitter");
            
            System.out.print("Choisissez une option : ");

            choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne après la saisie du choix

            traiterChoixMenuPrincipal(choix);
        } while (choix != 9);
    }

    private void traiterChoixMenuPrincipal(int choix1) {
        switch (choix1) {
            case 1:
            menuGestionChambre();
                break;
            case 2:
                /*/ creation client
                Client clientcree = new Client();
                clientcree.creerClient();
                Chambre chambreChoisi = choixChambre();
                String laDateDebut = demanderDateDebut();  
                String laDateFin = demanderDateFin();     
                effectuerReservation(clientcree, chambreChoisi, laDateDebut, laDateFin);
                afficherReservation();*/
                
                break;
            case 3:
                //modifierReservation();
                break;
            case 4:
               // annulerReservation();
                break;
            case 5:
                commanderRepas();
                break;
            case 6:
                enregistrerFacture();
                break;
            case 7:
                optionClient();
                break;
            case 8:
                System.out.println("MET TA METHODE ICI");
                break;
            case 9:
                System.out.println("Fin du programme !");
                break;
            default:
                System.out.println("Option non valide. Veuillez réessayer.");
        }
    }

    //----------------------------------------------------------------Gesttion des chambre ----------------------------------------------------------------
    
    // methode afficher les option des chambres (choix 1)
    public void menuGestionChambre(){

        int choix2;
        do{
            System.out.println("=== Menu de gestion de chambre ===\n1. Afficher les détails des chambres\n2. Afficher la disponibilité des chambres\n3. Ajouter une chambre à l'hotel");
            System.out.println("4. Quitter le menu  client");
            System.out.print("Choisissez une option : \n=> ");
            choix2 = scanner.nextInt();
            scanner.nextLine(); 
            newChambreDeLuxe.chargerChambreDeLuxe();
            newChambreNormale.chargerChambreNormal();

            traiterOptionChambre(choix2);

        } while (choix2 != 4);
    }
    //traitement du menu chambre 
    private void traiterOptionChambre(int choix3) {
  
        switch (choix3) {
            case 1:
                afficherDetailsChambres();
                break;
            case 2:
                afficherDisponibilitesChambres();
                break;
            case 3:
                ajouterChambre();
                break;
            case 4:
                System.out.println("Au revoir !");
                break;
        }    
         
    }

    public void afficherDetailsChambres() {
        Scanner scanner = new Scanner(System.in);
                
        System.out.println("Choisissez le type de chambre à afficher :");
        System.out.println("1. Chambre de luxe ");
        System.out.println("2. Chambre Normaux");
        System.out.println("3. Quitter ce menu ");
        System.out.print("Choisissez une option : \n=> ");

        int choix4 = scanner.nextInt();
              
        switch (choix4) {
            case 1:
                newChambreDeLuxe.afficherChambresDeLuxe();
                break;
            case 2:
                newChambreNormale.afficherChambresNormales();
                break;
            case 3:
                System.out.println("Au revoir !");
                break;
            default:
                System.out.println("Votre choix est invalide");
        }
        
    }

    private void afficherDisponibilitesChambres() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vous voulez voir les disponibilites de quel type de chambre");
        System.out.println("1. Chambre de luxe ");
        System.out.println("2. Chambre Normaux");
        System.out.println("3. Quitter ce menu ");
        System.out.print("Choisissez une option : \n=> ");

        int choix = scanner.nextInt();
        
        switch (choix) {
            case 1:
                newChambreDeLuxe.disponibilitesChambresDeLuxe();
                break;
            case 2:
                newChambreNormale.disponibilitesChambresNormales();
                break;

            case 3:
                System.out.println("Au revoir !");
                break;
            default:
                System.out.println("Votre choix est invalide");
        }
        

    }

    private void ajouterChambre(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vous voulez ajouter  quel type de chambre");
        System.out.println("1. Chambre de luxe ");
        System.out.println("2. Chambre Normaux");
        System.out.println("3. Quitter ce menu ");
        System.out.print("Choisissez une option : \n=> ");
        int choix = scanner.nextInt();
        switch (choix) {
            case 1:
                newChambreDeLuxe.creerChambreDeLuxe();
                break;
            case 2:
                newChambreNormale.creerChambreNormale();
                break;
            case 3:
                System.out.println("Au revoir !");
                break;
            default:
                System.out.println("Votre choix est invalide");
        }      
    }
    
    //----------------------------------------------------------------Fin gestion des chambres ----------------------------------------------------------------
    
    // choix 5
    private void commanderRepas() {
        // Ici tu vas faire appel aux methode necessaire et la logique pour passer la commande du repas
    }

    // choix 6
    private void enregistrerFacture() {
       
    }
    
    
    // methode pour gere menu option client (choix 8)
    public void optionClient(){

        int choix;
        do {
            System.out.println("=== Option Client ===\n1. Creer un client\n2. Afficher la liste de clients\n3. Modifier client");
            System.out.println("3. Modifier client (pas encore implementé)");
            System.out.println("4. Afficher resevation de clients (pas encore implementé)");
            System.out.println("5. Quitter le menu  client");
                        
            System.out.print("Choisissez une option : ");

            choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne après la saisie du choix

            traiterOptionClient(choix);
        } while (choix != 5);
    }

    //traitement du menu option client 
    private void traiterOptionClient(int choix) {
        switch (choix) {
            case 1:
                newClient.creerClient();
                break;
            case 2:
                Client.chargerClients();
                Client.listeClient();
                break;
             case 3:
               //a definir
                break;
            case 4:
                // a definir 
                break;
            case 5:
                System.out.println("Au revoir !");
                break;
            
        }
    }
   
       

    public Chambre choixChambre(){
        Scanner scanner = new Scanner(System.in);

        newChambreDeLuxe.afficherChambresDeLuxe();
        
        newChambreNormale.afficherChambresNormales();

        //  l'utilisateur choisit une chambre en entrant le numéro
        System.out.println("Entrez le numéro de la chambre que vous souhaitez réserver : ");
        int numeroChambreChoisi = scanner.nextInt();

        // Recherche de la chambre choisie parmi les chambres de luxe
        for (ChambreDeLuxe chambreDeLuxe : newChambreDeLuxe.getListChambreDeLuxe()) {
            if (chambreDeLuxe.getNumeroChambre() == numeroChambreChoisi) {
                return chambreDeLuxe;
            }
        }
        // Recherche de la chambre choisie parmi les chambres normales
        for (ChambreNormale chambreNormale : newChambreNormale.getListChambreNormale()) {
            if (chambreNormale.getNumeroChambre() == numeroChambreChoisi) {
                return chambreNormale;
            }
        }

        // cas ou le numero de chambre n'est pas valide
        System.out.println("Numéro de chambre non valide.");
        return null;
    }

    

////////////////////////////////////////////////    METHODE POUR lA RESERVATION    /////////////////////////////////
/* Je finis ca bientot j'ai des erreurs 
    

    private void effectuerReservation(Client client, Chambre chambre, String dateDebut, String dateFin) {
        
        //  generation d'un identifiant unique pour la reservation 
        int idReservation = genererIdReservation();

        //  creation d'une instance de la reservation
        Reservation reservation = new Reservation(idReservation, client, chambre, dateDebut, dateFin);
        
        //  utilisation de l'interface Reservable pour effectuer la reservation
        if (chambre instanceof Reservable) {
             // Vérification de la disponibilité de la chambre pour les dates spécifiées
            if (chambre.getDisponible().equals("Oui")) {           
                Reservable chambreReservable = (Reservable)chambre; // casting explicite 
                chambreReservable.makeReservation(client, chambre, dateDebut, dateFin);

                //  ajout de la reservation dans la liste des reservations
                ajouterReservation(reservation);

                //  Sauvegarde de la reservation
                sauvegarderReservation();

                // Mise à jour de l'état de la chambre
                chambre.setDisponible(false);

                System.out.println("La réservation a été effectuée avec succès. L'ID de réservation est : " + idReservation);
            }
            else{
                System.out.println("La chambre n'est pas disponible pour MOMENT.");
            }
        }
        else {
            System.out.println("Cette chambre ne peut pas être réservée.");
        }
    }


    public void afficherReservation() {
        System.out.println("Les reservation sont :");
        System.out.println("_________________________________________________________________________________________________________________________");
        for (Reservation reservation : reservations) {
            affichageReservation(reservation);
        }
    }

    public String affichageReservation(Reservation reservation) {
        
        return "Réservation #" + reservation.getIdReservation() + " :\n" +
                "Client : " + reservation.getClient().getNom() + " (" + reservation.getClient().getNumeroTel() + ")\n" +
                "Chambre : " + reservation.getChambre().getNumeroChambre() + " - " + reservation.getChambre().getTypeChambre() + "\n" +
                "Dates du séjour : " + reservation.getDateDebut() + " au " + reservation.getDateFin();
    }

    public static String demanderDateDebut() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez la date de début du séjour (format dd/MM/yyyy) : ");
        String dateDebutString = scanner.next();
    
        if (dateDebutString.isEmpty()) {
            System.out.println("Veuillez saisir une date de début valide.");
            return null;
        }
    
        return dateDebutString;
    }
    
    public static String demanderDateFin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez la date de fin du séjour (format dd/MM/yyyy) : ");
        String dateFinString = scanner.next();
    
        if (dateFinString.isEmpty()) {
            System.out.println("Veuillez saisir une date de fin valide.");
            return null;
        }
    
        return dateFinString;
    }    

    private void modifierReservation() {
        // Logique pour modifier une réservation
    }

    private void annulerReservation() {
        // Logique pour annuler une réservation
    }

*/
}
