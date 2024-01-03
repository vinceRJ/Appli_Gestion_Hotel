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
import model.Reservable;
import model.Facture;
import java.io.*;




public class HotelController {
    private final Scanner scanner;
    private static int idReservationCounter = 0;
    //private static int idCounter = 1;
    public static List<Reservation> reservations = new ArrayList<>();
    private List<Repas> repas;
    private List<Facture> factures;
    //private static List<Client> clients = new ArrayList<>();
    private List<ChambreNormale> chambreNormale = new ArrayList<>();
    private List<ChambreDeLuxe> chambreDeLuxe = new ArrayList<>();
    private List<Chambre> chambre;
    private Client newClient;

    public HotelController() {
        this.scanner = new Scanner(System.in);
        this.newClient = new Client();
        // Initialisations supplémentaires si nécessaires tel ajouter des chambres ou des repas
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
            System.out.println("8. Options  client ");
            System.out.println("9. Quitter");
            
            System.out.print("Choisissez une option : ");

            choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne après la saisie du choix

            traiterChoixMenuPrincipal(choix);
        } while (choix != 9);
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
                // creation client
                Client clientcree = new Client();
                clientcree.creerClient();
                Chambre chambreChoisi = choixChambre();
                String laDateDebut = demanderDateDebut();  
                String laDateFin = demanderDateFin();     
                effectuerReservation(clientcree, chambreChoisi, laDateDebut, laDateFin);
                afficherReservation();
                
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
                optionClient();
                break;
            case 9:
                System.out.println("Au revoir !");
                break;
            default:
                System.out.println("Option non valide. Veuillez réessayer.");
        }
    }
    // methode pour gere menu option client
    public void optionClient(){

        int choix;
        do {
            System.out.println("=== Option Client ===\n1. Creer un client\n2. Afficher la liste de clients\n3. Modifier client");
            System.out.println("3. Modifier client");
            System.out.println("4. Afficher resevation de clients");
            System.out.println("5. Quitter le menu  client");
                        
            System.out.print("Choisissez une option : ");

            choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne après la saisie du choix

            traiterOptionClient(choix);
        } while (choix != 5);
    }
    
    //methode pour gere menu option client
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
    // Ajoutez les autres méthodes spécifiques de contrôle ici
    // (afficherDetailsChambres, afficherDisponibilitesChambres, etc.)

    private void commanderRepas() {
        // Logique pour commander un repas
    }

    private void enregistrerFacture() {
        // Logique pour enregistrer la facture
    }

    // les methodes pour sauvegarder l'etat de l'hotel dans un fichier

    public void sauvegarderRepas() {
        sauvegarderListeDansFichier(repas, "repas.ser");
    }

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

    //  Méthode pour charger l'état de l'hôtel depuis un fichier
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
    // ========================METHODE DES CHAMBRE ============================    

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

    public void chargerChambreNormal() {
        chargerListeDepuisFichier("chambreNormal.ser", chambreNormale);
    }

    public void chargerChambreDeLuxe() {
        chargerListeDepuisFichier("chambreDeLuxe.ser", chambreDeLuxe);
    }

    public void sauvegarderChambreNormale() {
        sauvegarderListeDansFichier(chambreNormale, "chambreNormal.ser");
        System.out.println("Chambre a bien été sauvegardé avec succès.");
    }

    public void sauvegarderChambreDeLuxe() {
        System.out.println("Chambre a bien été sauvegardé avec succès.");
    }

    
    private void afficherDisponibilitesChambres() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vous voulez voir les disponibilites de quel type de chambre");
        System.out.println("1. Chambre de luxe ");
        System.out.println("2. Chambre Normaux");
        System.out.print("Choisissez une option : ");

        int choix = scanner.nextInt();
        switch (choix) {
            case 1:
                disponibilitesChambresDeLuxe();
                break;
            case 2:
                disponibilitesChambresNormales();
                break;
            default:
                System.out.println("Votre choix est invalide");
        }

    }

    private void messageAfficheChambres() {
        System.out.println("voici la liste des chambres :");
        System.out.println("_________________________________________________________________________________________________________________________");
        
    }
     private void afficherChambresDeLuxe() {
        messageAfficheChambres();
        for (ChambreDeLuxe chambre : chambreDeLuxe) {
            AffichageChambre(chambre);
        }
    }

    private void afficherChambresNormales() {
        messageAfficheChambres();
        for (ChambreNormale chambre : chambreNormale) {
            AffichageChambre(chambre);
        }
    }

    private void disponibilitesChambresDeLuxe() {
        messageAfficheChambres();
        for (ChambreDeLuxe chambre : chambreDeLuxe) {
            if (chambre.getDisponible()== "Oui") {
                AffichageChambre(chambre);
            }
        }
    }

    private void disponibilitesChambresNormales(){
        messageAfficheChambres();
        for (ChambreNormale chambre : chambreNormale) {
            if (chambre.getDisponible()== "Oui") {
                AffichageChambre(chambre);
            }
        }

    }
    //  Methode qui affiche les elements de la chambre 
    private void AffichageChambre(Chambre chambre){
        System.out.print("Numero de chambre : " + chambre.getNumeroChambre()+", "); 
        System.out.print(" Type de chambre: " + chambre.getTypeChambre()+", ");
        System.out.print(" Disponible: " + chambre.getDisponible()+", ");
        System.out.println(" Prix: " + chambre.getPrix()+" euros");
        System.out.println(chambre);
        System.out.println("_________________________________________________________________________________________________________________________");
    }
    public Chambre choixChambre(){
        Scanner scanner = new Scanner(System.in);

        afficherChambresDeLuxe();
        
        afficherChambresNormales();

        //  l'utilisateur choisit une chambre en entrant le numéro
        System.out.println("Entrez le numéro de la chambre que vous souhaitez réserver : ");
        int numeroChambreChoisi = scanner.nextInt();

        // Recherche de la chambre choisie parmi les chambres de luxe
        for (ChambreDeLuxe chambreDeLuxe : chambreDeLuxe) {
            if (chambreDeLuxe.getNumeroChambre() == numeroChambreChoisi) {
                return chambreDeLuxe;
            }
        }
        // Recherche de la chambre choisie parmi les chambres normales
        for (ChambreNormale chambreNormale : chambreNormale) {
            if (chambreNormale.getNumeroChambre() == numeroChambreChoisi) {
                return chambreNormale;
            }
        }

        // cas ou le numero de chambre n'est pas valide
        System.out.println("Numéro de chambre non valide.");
        return null;
    }

    public void afficherDetailsChambres() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Choisissez le type de chambre à afficher :");
        System.out.println("1. Chambre de luxe ");
        System.out.println("2. Chambre Normaux");
        System.out.print("Choisissez une option : ");

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

    //================================FIN DE LA CREATION ================================


    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    //================================ Creation, Sauvegarde et Charge Client =================================
    // Méthode statique pour créer un client depuis la ligne de commande
    

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////    FIN     ///////////////////////////////////////////////////////////


    ////////////////////////////////////////:://////////////////////////////////////////////////////////////
////////////////////////////////////////////////    METHODE POUR lA RESERVATION    //////////////////////////////////
    private static void ajouterReservation(Reservation reservation) {
        reservations.add(reservation);
    }
    public void sauvegarderReservation(){
        sauvegarderListeDansFichier(reservations, "reservations.ser");
        System.out.println("la Reservation a bien été sauvegardé avec succès.");
    }
    public void chargerReservations() {
        chargerListeDepuisFichier("reservations.ser", reservations);
    }

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

    private int genererIdReservation() {
        return ++idReservationCounter;
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


}
