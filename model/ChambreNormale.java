//Implémentation des Classes de Catégorie de Chambres avec Héritage 

package model;

import java.util.Date;

public class ChambreNormale extends Chambre implements Reservable {

    private String[] servicesNormaux;
    private boolean vueSurMer;
    private int capaciteMax;
    private boolean litSimple;
    private boolean litDouble;

    public ChambreNormale(int numeroChambre, boolean disponible, double prix, String[] servicesNormaux, boolean vueSurMer, int capaciteMax, boolean litSimple, boolean litDouble) {
        super(numeroChambre, "ChambreNormale", disponible, prix);
        this.servicesNormaux = servicesNormaux;
        this.vueSurMer = vueSurMer;
        this.capaciteMax = capaciteMax;
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
}

