//Implémentation de l'Interface Reservable

package model;


public interface Reservable {
    void Reservation(Client client, Chambre chambre,  String dateDebut, String dateFin); 
    void modifyReservation(Reservation reservation,  Chambre newChambre, String newDateDebut, String newDateFin);
    void cancelReservation(Reservation reservation);
}
