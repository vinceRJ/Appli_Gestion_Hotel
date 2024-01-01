//Implémentation des Classes de Catégorie de Chambres avec Héritage 

package model;

import java.util.Arrays;
import java.util.Date;
import java.io.Serializable;

public class ChambreNormale extends Chambre implements Reservable, Serializable {
    private static final long serialVersionUID = 1L;


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

    @Override
    public void makeReservation(Client client, Chambre chambre, Date dateDebut, Date dateFin) {
        // Logique de réservation pour une chambre normale
    }

    @Override
    public void modifyReservation(Reservation reservation, Chambre newChambre, Date newDateDebut, Date newDateFin) {
        // Logique de modification de réservation pour une chambre normale
    }

    @Override
    public void cancelReservation(Reservation reservation) {
        // Logique d'annulation de réservation pour une chambre normale
    }


    public String[] getServicesNormaux() {
        return this.servicesNormaux;
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
            ", litSimple='" + getLitSimple() + "'" +
            ", litDouble='" + getLitDouble() + "'" ;
    }

}

