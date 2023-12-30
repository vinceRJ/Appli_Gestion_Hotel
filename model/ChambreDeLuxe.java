//Implémentation des Classes de Catégorie de Chambres avec Héritage 

package model;

import java.util.Date;

public class ChambreDeLuxe extends Chambre implements Reservable {
    
    private String[] servicesSupplementaires;

    // Constructeur, getters, setters

    // Implémentation des méthodes de l'interface Reservable  
    @Override
    public void makeReservation(Client client, Chambre chambre, Date dateDebut, Date dateFin){

        // Definir la Logique de réservation pour une chambre de luxe
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
