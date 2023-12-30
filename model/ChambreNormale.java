//Implémentation des Classes de Catégorie de Chambres avec Héritage 

package model;

import java.util.Date;

public class ChambreNormale extends Chambre implements Reservable {

    private String[] servicesNormal;
    // Constructeur, getters, setters

    // Implémentation des méthodes de l'interface Reservable

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
