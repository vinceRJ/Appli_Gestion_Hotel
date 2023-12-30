//Implémentation de l'Interface Reservable

package model;

import java.util.Date;

public interface Reservable {
    void makeReservation(Client client, Chambre chambre,  Date dateDebut, Date dateFin); 
    void modifyReservation(Reservation reservation,  Chambre newChambre, Date newDateDebut, Date newDateFin);
    void cancelReservation(Reservation reservation);
}
