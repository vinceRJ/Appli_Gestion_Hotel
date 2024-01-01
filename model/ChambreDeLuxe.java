//Implémentation des Classes de Catégorie de Chambres avec Héritage 

package model;

import java.util.Arrays;
import java.util.Date;
import java.io.Serializable;

public class ChambreDeLuxe extends Chambre implements Reservable, Serializable {
    private static final long serialVersionUID =  1L;


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

    @Override
    public void makeReservation(Client client, Chambre chambre, Date dateDebut, Date dateFin) {
        // Logique de réservation pour une chambre de luxe
    }

    @Override
    public void modifyReservation(Reservation reservation, Chambre newChambre, Date newDateDebut, Date newDateFin) {
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
            "services Supplementaires=" +  Arrays.toString(servicesSupplementaires)  +
            ", jacuzzi='" + getJacuzzi() + "'" +
            ", litSimple='" + getLitSimple() + "'" +
            ", litDouble='" + getLitDouble() + "'" ;
    }


}

