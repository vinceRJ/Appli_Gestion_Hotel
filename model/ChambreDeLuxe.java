//Implémentation des Classes de Catégorie de Chambres avec Héritage 

package model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ChambreDeLuxe extends Chambre implements Reservable {
    private static final long serialVersionUID =  1L;
    private List<ChambreDeLuxe> chambreDeLuxe = new ArrayList<>();

    private String[] servicesSupplementaires;
    private boolean jacuzzi;
    private boolean litSimple;
    private boolean litDouble;

    public ChambreDeLuxe(int numeroChambre, boolean disponible, double prix, String[] servicesSupplementaires, boolean jacuzzi, boolean litSimple, boolean litDouble) {
        super(numeroChambre, "ChambreDeLuxe", disponible, prix);
        this.servicesSupplementaires = servicesSupplementaires;
        this.jacuzzi = jacuzzi;
        this.litSimple = litSimple;
        this.litDouble = litDouble;
    }
    public ChambreDeLuxe(){
        super();

    }

    @Override
    public void makeReservation(Client client, Chambre chambre, String dateDebut, String dateFin) {
        // Logique de réservation pour une chambre de luxe
    }

    @Override
    public void modifyReservation(Reservation reservation, Chambre newChambre, String newDateDebut, String newDateFin) {
        // Logique de modification de réservation pour une chambre de luxe
    }

    @Override
    public void cancelReservation(Reservation reservation) {
        // Logique d'annulation de réservation pour une chambre de luxe
    }

    public String[] getServicesSupplementaires() {
        return this.servicesSupplementaires;
    }

    public void setServicesSupplementaires(String[] servicesSupplementaires) {
        this.servicesSupplementaires = servicesSupplementaires;
    }

    //getter
    public List<ChambreDeLuxe> getListChambreDeLuxe(){
        return this.chambreDeLuxe ;
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
    public void chargerChambreDeLuxe() {
        chargerListeDepuisFichier("chambreDeLuxe.ser", chambreDeLuxe);
    }

    //// sauvegarde chambre dans le fichier
    public void sauvegarderChambreDeLuxe() {
        System.out.println("Chambre a bien été sauvegardé avec succès.");
    }

    // ajout de la chambre dans la liste des chambre de luxe
    public  void ajouterChambreDeLuxe(ChambreDeLuxe laChambreDeLuxe) {
        chambreDeLuxe.add(laChambreDeLuxe);
    }

    // affichage de toutes les chambre de luxes
    public void afficherChambresDeLuxe() {
        messageAfficheChambres();
        for (ChambreDeLuxe chambre : chambreDeLuxe) {
            AffichageChambre(chambre);
        }
    }

    // afficher chambre de luxe disponible
    public void disponibilitesChambresDeLuxe() {
        messageAfficheChambres();
        for (ChambreDeLuxe chambre : chambreDeLuxe) {
            if (chambre.getDisponible()== "Oui") {
                AffichageChambre(chambre);
            }
        }
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

