package model;

public class Facture {
    private int idFacture;
    private Reservation reservation;
    private double prixChambre;
    private double prixRepas;
    private double total;

    // Constructeur
    public Facture(int idFacture, Reservation reservation, double prixChambre, double prixRepas, double total) {
        this.idFacture = idFacture;
        this.reservation = reservation;
        this.prixChambre = prixChambre;
        this.prixRepas = prixRepas;
        this.total = total;
    }

    // Getters
    public int getIdFacture() {
        return idFacture;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public double getPrixChambre() {
        return prixChambre;
    }

    public double getPrixRepas() {
        return prixRepas;
    }

    public double getTotal() {
        return total;
    }

    // Setters
    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void setPrixChambre(double prixChambre) {
        this.prixChambre = prixChambre;
    }

    public void setPrixRepas(double prixRepas) {
        this.prixRepas = prixRepas;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
