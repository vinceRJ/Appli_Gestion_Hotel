//Implémentation des Classes de Catégorie de Chambres avec Héritage 

package model;

import java.util.Date;

public class ChambreDeLuxe extends Chambre implements Reservable {

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
}

