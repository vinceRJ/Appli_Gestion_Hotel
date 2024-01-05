//Implémentation des Classes de Catégorie de Chambres avec Héritage 

package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class ChambreNormale extends Chambre implements Reservable {
    private static final long serialVersionUID = 1L;
    private List<ChambreNormale> chambreNormale = new ArrayList<>();

    private String[] servicesNormaux;
    private boolean vueSurMer;
    private boolean litSimple;
    private boolean litDouble;


    public ChambreNormale(int numeroChambre, boolean disponible, double prix, String[] servicesNormaux, boolean vueSurMer, boolean litSimple, boolean litDouble) {
        super(numeroChambre, "ChambreNormale", disponible, prix);
        this.servicesNormaux = servicesNormaux;
        this.vueSurMer = vueSurMer;
        this.litSimple = litSimple;
        this.litDouble = litDouble;
    }

    // construteur sans parametres
    public ChambreNormale(){
        
    }

    
    public void makeReservation(Client client, Chambre chambre, String dateDebut, String dateFin) {
        if (chambre.getDisponible()== "Non") {
            System.out.println("cette chambre n'est pas Disponible ! ");
        }      
        
        Reservation laReservation = new Reservation(client, this, dateDebut, dateFin);

        // Ajouter la réservation à la liste des réservations
        Reservation.ajouterReservation(laReservation);

        //// sauvegarde  dans le fichier
        Reservation.sauvegarderReservation();

    }

    
    public void modifyReservation(Reservation reservation, Chambre nouvelleChambre, String newDateDebut, String newDateFin) {
        if (!Reservation.reservations.contains(reservation)) { // si la n'est pas dans la liste des réservations
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
    }

    
    public void cancelReservation(Reservation reservation) {
        if(Reservation.reservations.contains(reservation)){
            // Supprimer la réservation de la liste
            Reservation.reservations.remove(reservation);

            //mise à jour dans de la liste 
            Reservation.sauvegarderReservation();

        }
    }

    public String[] getServicesNormaux() {
        return this.servicesNormaux;
    }

    public List<ChambreNormale> getListChambreNormale(){
        return this.chambreNormale;
    }

    public void setServicesNormaux(String[] servicesNormaux) {
        this.servicesNormaux = servicesNormaux;
    }

    public String getVueSurMer() {
        return this.vueSurMer? "Oui" : "Non";
    }

    public void setVueSurMer(boolean vueSurMer) {
        this.vueSurMer = vueSurMer;
    }

    public String getLitSimple() {
        return this.litSimple ? "Oui" : "Non";
    }

    public void setLitSimple(boolean litSimple) {
        this.litSimple = litSimple;
    }

    public String getLitDouble() {
        return this.litDouble ? "Oui" : "Non";
    }

    public void setLitDouble(boolean litDouble) {
        this.litDouble = litDouble;
    }

    @Override
    public String toString() {
        return 
            "services normale=" +  Arrays.toString(servicesNormaux)  +
            ", vue Sur Mer='" + getVueSurMer() + "'" +
            ", lit Simple='" + getLitSimple() + "'" +
            ", lit Double='" + getLitDouble() + "'" ;
    }

    // ajout de la chambre dans la liste des chambre de luxe
    public  void ajouterClient(ChambreNormale laChambre) {
        chambreNormale.add(laChambre);
    }

    // Méthode pour créer une chambre normal depuis la console
    public ChambreNormale creerChambreNormale() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le numéro de la chambre : ");
        int numeroChambre = scanner.nextInt();
        scanner.nextLine();  

        System.out.println("La chambre est-elle disponible ? (Oui/Non) : ");
        boolean disponible = scanner.nextLine().equalsIgnoreCase("Oui");

        System.out.println("Entrez le prix de la chambre : ");
        double prix = scanner.nextDouble();
        scanner.nextLine();  

        System.out.println("Entrez les services normaux pour la chambre : ");
        String []servicesNormaux = scanner.nextLine().split(",");

        System.out.println("La chambre a-t-elle une vue sur la mer ? (Oui/Non) : ");
        boolean vueSurMer = scanner.nextLine().equalsIgnoreCase("Oui");

        System.out.println("La chambre a-t-elle un lit simple ? (Oui/Non) : ");
        boolean litSimple = scanner.nextLine().equalsIgnoreCase("Oui");

        System.out.println("La chambre a-t-elle un lit double ? (Oui/Non) : ");
        boolean litDouble = scanner.nextLine().equalsIgnoreCase("Oui");

        // Crée une nouvelle instance de ChambreNormale
        ChambreNormale nouvelleChambre = new ChambreNormale(numeroChambre, disponible, prix, servicesNormaux, vueSurMer, litSimple, litDouble);

        // Ajoute la nouvelle chambre à la liste
        ajouterChambreNormale(nouvelleChambre);

        // Sauvegarde de la chambre
        sauvegarderChambreNormale();

        // Retourne la nouvelle instance de ChambreNormale
        return nouvelleChambre;
    }

    //// charger chambre depuis le fichier
    public void chargerChambreNormal() {
        chargerListeDepuisFichier("chambreNormal.ser", chambreNormale);
    }

    //// sauvegarde chambre dans le fichier
    public void sauvegarderChambreNormale() {
        sauvegarderListeDansFichier(chambreNormale, "chambreNormal.ser");
        System.out.println("Chambre a bien été sauvegardé avec succès.");
    }

    // ajout de la chambre dans la liste des chambre de luxe
    public  void ajouterChambreNormale(ChambreNormale laChambreNormale) {
        chambreNormale.add(laChambreNormale);
    }

    public void afficherChambresNormales() {
        messageAfficheChambres();
        for (ChambreNormale chambre : chambreNormale) {
            AffichageChambre(chambre);
        }
    }

    public void disponibilitesChambresNormales(){
        messageAfficheChambres();
        for (ChambreNormale chambre : chambreNormale) {
            if (chambre.getDisponible()== "Oui") {
                AffichageChambre(chambre);
            }
        }

    }

    @Override
    public void Reservation(Client client, Chambre chambre, String dateDebut, String dateFin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Reservation'");
    }

}

