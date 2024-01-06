//Implémentation de l'Interface Reservable

package model;


public interface Reservable {
    void FaireReservation(Client client, Chambre chambre,  String dateDebut, String dateFin); 
    void modifierReservation(Reservation reservation,  Chambre newChambre, String newDateDebut, String newDateFin);
    void annulerReservation(Reservation reservation);
}
