package model;

public class Repas {
    private int idRepas;
    private Client client;
    private String typeRepas;
    private double prixRepas;

    // Constructeur
    public Repas(int idRepas, Client client, String typeRepas, double prixRepas) {
        this.idRepas = idRepas;
        this.client = client;
        this.typeRepas = typeRepas;
        this.prixRepas = prixRepas;
    }

    // Getters
    public int getIdRepas() {
        return idRepas;
    }

    public Client getClient() {
        return client;
    }

    public String getTypeRepas() {
        return typeRepas;
    }

    public double getPrixRepas() {
        return prixRepas;
    }

    // Setters
    public void setIdRepas(int idRepas) {
        this.idRepas = idRepas;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setTypeRepas(String typeRepas) {
        this.typeRepas = typeRepas;
    }

    public void setPrixRepas(double prixRepas) {
        this.prixRepas = prixRepas;
    }
}
