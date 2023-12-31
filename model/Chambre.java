package model;

public class Chambre {
    private int numeroChambre;
    private String typeChambre;
    private boolean disponible;
    private double prix;

    // Constructeur

    public Chambre(int numeroChambre, String typeChambre, boolean disponible, double prix) {
        this.numeroChambre = numeroChambre;
        this.typeChambre = typeChambre;
        this.disponible = disponible;
        this.prix = prix;
    }

    //getters
    public int getNumeroChambre() {
        return numeroChambre;
    }

    public String getTypeChambre() {
        return typeChambre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public double getPrix() {
        return prix;
    } 
    
    
    
    //setters
    public void setNumeroChambre(int numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public void setTypeChambre(String typeChambre) {
        this.typeChambre = typeChambre;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

}
