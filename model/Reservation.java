package model;

import java.io.Serializable;


public class Reservation implements Serializable{
    private static final long serialVersionUID = 1L;
    
    
    private int idReservation;
    private Client client;
    private Chambre chambre;
    private String dateDebut;
    private String dateFin;

    // Constructeur
    public Reservation(int idReservation, Client client, Chambre chambre, String dateDebut, String dateFin) {
        this.idReservation = idReservation;
        this.client = client;
        this.chambre = chambre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    // Getters
    public int getIdReservation() {
        return idReservation;
    }

    public Client getClient() {
        return client;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    // Setters
    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }



    @Override
    public String toString() {
        return "{" +
            " idReservation='" + getIdReservation() + "'" +
            ", client='" + getClient() + "'" +
            ", chambre='" + getChambre() + "'" +
            ", dateDebut='" + getDateDebut() + "'" +
            ", dateFin='" + getDateFin() + "'" +
            "}";
    }

    


}
