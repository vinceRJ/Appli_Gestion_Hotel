//Implémentation des Classes de Catégorie de Chambres avec Héritage 

package model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ChambreDeLuxe extends Chambre implements Reservable {
    private static final long serialVersionUID =  1L;
    private static List<ChambreDeLuxe> LalisteDeschambreDeLuxe = new ArrayList<>();

    private String[] servicesSupplementaires;
    private boolean jacuzzi;
    private boolean litSimple;
    private boolean litDouble;

    public ChambreDeLuxe(int numeroChambre, boolean disponible, double prix, String[] servicesSupplementaires, boolean jacuzzi, boolean litSimple, boolean litDouble) {
        super(numeroChambre, "Chambre De Luxe", disponible, prix);
        this.servicesSupplementaires = servicesSupplementaires;
        this.jacuzzi = jacuzzi;
        this.litSimple = litSimple;
        this.litDouble = litDouble;
    }
    public ChambreDeLuxe(){

    }

    public void FaireReservation(Client client, Chambre chambre, String dateDebut, String dateFin) {
        if (chambre.getDisponible()== "Non") {
            System.out.println("cette chambre n'est pas Disponible ! ");
        }      
        
        chambre.setDisponible(false);
        Reservation laReservation = new Reservation(client, chambre, dateDebut, dateFin);

        // Ajouter la réservation à la liste des réservations
        Reservation.ajouterReservation(laReservation);

        //// sauvegarde  dans le fichier
        Reservation.sauvegarderReservation();
        sauvegarderChambreDeLuxe();

        System.out.println("---------------------------- Voici votre reservation ------------------------------------------");
        Reservation.affichageReservation(laReservation);

    }

    
    public void modifierReservation(Reservation reservation, Chambre nouvelleChambre, String newDateDebut, String newDateFin) {
        if (!Reservation.laListeDesReservations.contains(reservation)) { // si la n'est pas dans la liste des réservations
            System.out.println("La réservation spécifiée n'existe pas pour la chambre");
            return; 
        }

        //Vérifier la disponibilité de la nouvelle chambre 
        if (nouvelleChambre.getDisponible() == "Non") {
            System.out.println("La nouvelle chambre n'est pas disponible.");
            return;   
        }

        reservation.setChambre(nouvelleChambre);
        reservation.setDateDebut(newDateDebut);
        reservation.setDateFin(newDateFin);
        reservation.sauvegarderModification();

        // l'ancienne chambre devient disponible
        reservation.chambre.setDisponible(true);

        // la nouvelle chambre devient indisponible
        nouvelleChambre.setDisponible(false);
        System.out.println("Modification de la réservation effectuée avec succès.");
        sauvegarderChambreDeLuxe();
    }

    public void annulerReservation(Reservation reservation) {
        if(Reservation.laListeDesReservations.contains(reservation)){
            // Supprimer la réservation de la liste
            Reservation.laListeDesReservations.remove(reservation);

            //mise à jour dans de la liste 
            Reservation.sauvegarderReservation();

        }
    }

    public String[] getServicesSupplementaires() {
        return this.servicesSupplementaires;
    }

    public void setServicesSupplementaires(String[] servicesSupplementaires) {
        this.servicesSupplementaires = servicesSupplementaires;
    }

    //getter
    public List<ChambreDeLuxe> getListChambreDeLuxe(){
        return LalisteDeschambreDeLuxe;
    }

    public String getLitDouble() {
        return litDouble ? "Oui" : "Non";
    }

    public String getJacuzzi() {
        return jacuzzi ? "Oui" : "Non";
    }

    public String getLitSimple() {
        return litSimple ? "Oui" : "Non";
    }

    //setter
    public void setJacuzzi(boolean jacuzzi) {
        this.jacuzzi = jacuzzi;
    }

    public void setLitSimple(boolean litSimple) {
        this.litSimple = litSimple;
    }

    public void setLitDouble(boolean litDouble) {
        this.litDouble = litDouble;
    }
    
    @Override
    public String toString() {
        return 
            "services Supplementaires=" +   Arrays.toString(servicesSupplementaires) +
            ", jacuzzi='" + getJacuzzi() + "'" +
            ", lit Simple='" + getLitSimple() + "'" +
            ", lit Double='" + getLitDouble() + "'" ;
    }

    //// charger chambre depuis le fichier
    public static void chargerChambreDeLuxe() {
        chargerListeDepuisFichier("chambreDeLuxe.ser", LalisteDeschambreDeLuxe);
    }

    //// sauvegarde chambre dans le fichier
    public void  sauvegarderChambreDeLuxe() {
        System.out.println("Chambre a bien été sauvegardé avec succès.");
    }

    // ajout de la chambre dans la liste des chambre de luxe
    public  void ajouterChambreDeLuxe(ChambreDeLuxe laChambreDeLuxe) {
        LalisteDeschambreDeLuxe.add(laChambreDeLuxe);
    }

    // affichage de toutes les chambre de luxes
    public void afficherChambresDeLuxe() {
        messageAfficheChambres();
        for (ChambreDeLuxe chambre : LalisteDeschambreDeLuxe) {
            AffichageChambre(chambre);
        }
    }

    // afficher chambre de luxe disponible
    public void disponibilitesChambresDeLuxe() {
        messageAfficheChambres();
        for (ChambreDeLuxe chambre : LalisteDeschambreDeLuxe) {
            if (chambre.getDisponible()== "Oui") {
                AffichageChambre(chambre);
            }
        }
    }

    public static ChambreDeLuxe ChoixChambresLuxePourReservation(){
        ChambreDeLuxe chambreChoisie = new ChambreDeLuxe();
        Scanner scanner = new Scanner(System.in);
        chargerChambreDeLuxe();
        boolean test =true;
        while(test){
            messageAfficheChambres();
            int compteur = 1;

            for (ChambreDeLuxe chambre : LalisteDeschambreDeLuxe) {
                if (chambre.getDisponible().equalsIgnoreCase("Oui")) {
                    System.out.print(compteur + ". ");
                    AffichageChambre(chambre);
                    compteur++;
                }
            }
        
            System.out.print("Choisissez le numéro de la chambre que vous souhaitez réserver :\n=> ");
            int numeroChoisi = scanner.nextInt();
            if (numeroChoisi > 0 && numeroChoisi<= compteur - 1) {
                chambreChoisie  = LalisteDeschambreDeLuxe.get(numeroChoisi -1);
                test = false;
                return chambreChoisie;
            }
            else {
                System.out.println("Aucune chambre sélectionnée.");
                continue;
            }
        } 
        return null;
    }

    // Méthode pour créer une chambre de luxe depuis la console
    public ChambreDeLuxe creerChambreDeLuxe() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Entrez le numéro de la chambre : ");
        int numeroChambre = scanner.nextInt();
        scanner.nextLine();  
    
        System.out.println("La chambre est-elle disponible ? (Oui/Non) : ");
        boolean disponible = scanner.nextLine().equalsIgnoreCase("Oui");
    
        System.out.println("Entrez le prix de la chambre : ");
        double prix = scanner.nextDouble();
        scanner.nextLine();  
    
        System.out.println("Entrez les services supplémentaires pour la chambre : ");
        String[] servicesSupplementaires = scanner.nextLine().split(",");
    
        System.out.println("La chambre a-t-elle un jacuzzi ? (Oui/Non) : ");
        boolean jacuzzi = scanner.nextLine().equalsIgnoreCase("Oui");
    
        System.out.println("La chambre a-t-elle un lit simple ? (Oui/Non) : ");
        boolean litSimple = scanner.nextLine().equalsIgnoreCase("Oui");
    
        System.out.println("La chambre a-t-elle un lit double ? (Oui/Non) : ");
        boolean litDouble = scanner.nextLine().equalsIgnoreCase("Oui");
    
        // Crée une nouvelle instance de ChambreDeLuxe
        ChambreDeLuxe nouvelleChambre = new ChambreDeLuxe(numeroChambre, disponible, prix, servicesSupplementaires, jacuzzi, litSimple, litDouble);
    
        // Ajoute la nouvelle chambre à la liste
        ajouterChambreDeLuxe(nouvelleChambre);
    
        // Sauvegarde de la chambre
        sauvegarderChambreDeLuxe();
    
        // Retourne la nouvelle instance de ChambreDeLuxe
        return nouvelleChambre;
    }

    

    
}

