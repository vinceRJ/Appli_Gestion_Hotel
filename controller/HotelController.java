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




public class HotelController {
    private final Scanner scanner;
        
    private Client newClient;
    private ChambreDeLuxe newChambreDeLuxe;
    private ChambreNormale newChambreNormale;
    private Repas newRepas;

    public HotelController() {
        this.scanner = new Scanner(System.in);
        this.newClient = new Client();
        this.newChambreDeLuxe = new ChambreDeLuxe();
        this.newChambreNormale = new ChambreNormale();
        this.newRepas = new Repas();

        // Initialisations supplémentaires  tel ajouter des chambres ou des repas ou reservation
    }

    public void afficherMenuPrincipal() {
        int choix;
        do {
            System.out.println(""); //
            System.out.println("============================= Menu Principal =============================");
            System.out.println("1. Gestion des chambres");
            System.out.println("2. Effectuer une réservation ");
            System.out.println("3. Modifier une réservation (en cours d'implementation)");
            System.out.println("4. Afficher la liste des reservations ");
            System.out.println("5. Annuler une réservation (pas encore implementé)");
            System.out.println("6. Commander un repas ");  
            System.out.println("7. Enregistrer la facture (pas encore implementé)");
            System.out.println("8. Gestion des client ");
            System.out.println("9. Gestion des repas "); 
            System.out.println("10. Quitter");
            
            System.out.print("Choisissez une option : ");

            choix = scanner.nextInt();
            scanner.nextLine(); 

            traiterChoixMenuPrincipal(choix);
        } while (choix != 10);
    }

    private void traiterChoixMenuPrincipal(int choix1) {
        switch (choix1) {
            case 1:
            menuGestionChambre();
                break;
            case 2:
                effectuerReservation();
                break;
            case 3:
                modifierReservation();
                break;
            case 4:
                Reservation.afficherReservation();
                break;
            case 5:
               // annulerReservation();
                break;
            case 6:
                commanderRepas();
                break;
            case 7:
                enregistrerFacture();
                break;
            case 8:
                optionClient();
                break;
            case 9:
                optionRepas();
                break;
            case 10:
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
            ChambreDeLuxe.chargerChambreDeLuxe();
            ChambreNormale.chargerChambreNormal();

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

//---------------------------------------------------------------- Gestion des Reservations ----------------------------------------------------------------
    // choix 2
    private void effectuerReservation(){
        int choix6;
        do{
            System.out.println("=== Interface de reservation de chambre ===\nQuel type de chambre souhaitez-vous prendre ?\n1. Chambre Normal\n2. Chambre de Luxe");
            System.out.println("3. Quitter ce menu");
            System.out.print("Choisissez une option : \n=> ");
            choix6 = scanner.nextInt();

            traiterOptionReservation(choix6);
            
        }while(choix6 != 3);

    }
    // traitement de la reservation
    private void traiterOptionReservation(int choix){
        Client clientQuiReserve = new Client();
        clientQuiReserve = Client.choixClientPourReservation();

        switch (choix) {
            case 1:
                ChambreNormale chambreReserve = new ChambreNormale();
                                
                // la methode FaireReservation est une  methde non static voila pourquoi je crée une instance
                ChambreNormale chambreReser = new ChambreNormale();

                chambreReserve = ChambreNormale.ChoixChambresNormalesPourReservation();
                
                String laDateDebut = Reservation.demanderDateDebut();  
                String laDateFin = Reservation.demanderDateFin();

                chambreReser.FaireReservation(clientQuiReserve, chambreReserve, laDateDebut, laDateFin);
                break;
            case 2:
                ChambreDeLuxe chambreLuxeReserve = new ChambreDeLuxe();
                
                // la methode FaireReservation est une  methde non static voila pourquoi je crée une instance
                ChambreDeLuxe chambreReserL = new ChambreDeLuxe();

                chambreLuxeReserve = ChambreDeLuxe.ChoixChambresLuxePourReservation();
                String laDateDebutL = Reservation.demanderDateDebut();  
                String laDateFinL = Reservation.demanderDateFin();

                chambreReserL.FaireReservation(clientQuiReserve, chambreLuxeReserve, laDateDebutL, laDateFinL);
                break;
            case 3:
                System.out.println("Au revoir !");
                break;
        }

    }

    //choix 3
    private void modifierReservation(){
        int choix;
        do{
            System.out.println("=== Interface de modification de reservation de chambre ===\nVotre reservation concerne quel type ?\n1. Chambre Normal\n2. Chambre de Luxe");
            System.out.println("3. Quitter ce menu");
            System.out.print("Choisissez une option : \n=> ");
            choix = scanner.nextInt();
            
            traiterModifReservation(choix);
        }while(choix != 3);
    }

    private void traiterModifReservation(int choix){
        Reservation reservationFaite = new Reservation();
        switch (choix){
            case 1:
                reservationFaite =  Reservation.ChoixReservation();
                ChambreNormale nouvelleChambreReserve = new ChambreNormale();

                ChambreNormale chambreIntermediaire = new ChambreNormale();

                nouvelleChambreReserve = ChambreNormale.ChoixChambresNormalesPourReservation();
                String laDateDebut = Reservation.demanderDateDebut();  
                String laDateFin = Reservation.demanderDateFin();

                chambreIntermediaire.modifierReservation(reservationFaite, nouvelleChambreReserve, laDateDebut, laDateFin);
                break;
            case 2:
                reservationFaite =  Reservation.ChoixReservation();
                ChambreDeLuxe nouvelleChambreReserveL = new ChambreDeLuxe();

                ChambreNormale chambreIntermediaireL = new ChambreNormale();
                nouvelleChambreReserveL = ChambreDeLuxe.ChoixChambresLuxePourReservation();

                String laDateDebutL = Reservation.demanderDateDebut();  
                String laDateFinL = Reservation.demanderDateFin();

                chambreIntermediaireL.modifierReservation(reservationFaite, nouvelleChambreReserveL, laDateDebutL, laDateFinL);
                break;
            case 3:
                System.out.println("Au revoir !");
                break;
        }

    }



 //---------------------------------------------------------------- Fin Gestion de la Reservation ----------------------------------------------------------------

    // choix 7
    private void enregistrerFacture() {
       
    }
    
///////////////////////////////////////////////     GESTION CLIENT        //////////////////////////////////////////////////////////////////

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
            scanner.nextLine(); 

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

        newChambreDeLuxe.afficherChambresDeLuxe();
        
        newChambreNormale.afficherChambresNormales();

        //  l'utilisateur choisit une chambre en entrant le numéro
        System.out.println("Entrez le numéro de la chambre que vous souhaitez réserver : ");
        int numeroChambreChoisi = scanner.nextInt();

        for (ChambreDeLuxe chambreDeLuxe : newChambreDeLuxe.getListChambreDeLuxe()) {
            if (chambreDeLuxe.getNumeroChambre() == numeroChambreChoisi) {
                return chambreDeLuxe;
            }
        }
        for (ChambreNormale chambreNormale : newChambreNormale.getListChambreNormale()) {
            if (chambreNormale.getNumeroChambre() == numeroChambreChoisi) {
                return chambreNormale;
            }
        }

        // cas ou le numero de chambre n'est pas valide
        System.out.println("Numéro de chambre non valide.");
        return null;
    }

////////////////////////////////////////////          FIN GESTION CLIENT      //////////////////////////////////////////////////////////////////

////////////////////////////////////////////    GESTION REPAS        //////////////////////////////////////////////////////////////////    
    // choix 6
    private void commanderRepas(){
        int choix1;
        do{
            System.out.println("======================== Interface de commande de repas ===================================\n1. Commander");
            System.out.println("2. Quitter ce menu");
           choix1 = scanner.nextInt();

           traitercommanderRepas(choix1);
        }while(choix1 != 2);


    }
    // traiter commander Repas
    private void traitercommanderRepas(int choix){
        switch (choix) {
            case 1:
                Client clientQuiCommande =  Client.choixClientPourReservation();
                Repas.commanderRepas(clientQuiCommande, Repas.choisirRepas());
                System.out.println("Votre commande a ete effectue ! ");
            case 2:
                System.out.println("Au revoir !");
                break;
        }


    }

    // choix 9
    private void optionRepas(){
        Repas.creerPlats();
        int choix;
        do {
            System.out.println("=== Option Repas ===\n1. Ajouter un repas dans liste des repas\n2. Afficher la liste des repas disponible \n3. Afficher les repas commandes");
            System.out.println("4. Quitter le menu  Repas");
                        
            System.out.print("Choisissez une option : ");

            choix = scanner.nextInt();
            scanner.nextLine(); 
            traiterOptionRepas(choix);
        } while (choix != 4);

    }

    //traitement du menu option Repas 
    private void traiterOptionRepas(int choix) {
        switch (choix) {
            case 1:
                newRepas.creerRepas();
                break;
            case 2:
                Repas.chargerRepas();
                Repas.listeRepas();
                break;
            case 3:
                Repas.chargerRepasCommander();
                Repas.listeRepasCommander();
                break;
            case 4:
                System.out.println("Au revoir !");
                break;
            
        }
    }

//////////////////////////////////////// FIN GESTION REPAS //////////////////////////////////////////////////////////////////   


}
