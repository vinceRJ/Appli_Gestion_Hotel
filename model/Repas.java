package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repas implements Serializable {
    private static final long serialVersionUID = 1L;
    private static List<Repas> repas = new ArrayList<>();
    private static final String FICHIER_REPAS = "repas.ser";
    private static final int STOCK_INITIAL_REPAS = 10;
    private static int stockPrecedent = STOCK_INITIAL_REPAS;

    private int idRepas;
    private Client client;
    private String typeRepas;
    private double prixRepas;
    private int stockDisponible;
    private boolean commande;

    // Constructeur
    public Repas(int idRepas, Client client, String typeRepas, double prixRepas, int stockDisponible, int stockPrecedent) {
        this.idRepas = idRepas;
        this.client = client;
        this.typeRepas = typeRepas;
        this.prixRepas = prixRepas;
        this.stockDisponible = stockDisponible;
        this.commande = false;
        this.stockPrecedent = stockPrecedent;
    }

    // constructeur sans paramètres
    public Repas() {
    }

    // Getters et Setters
    public int getIdRepas() {
        return idRepas;
    }

    public void setIdRepas(int idRepas) {
        this.idRepas = idRepas;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getTypeRepas() {
        return typeRepas;
    }

    public void setTypeRepas(String typeRepas) {
        this.typeRepas = typeRepas;
    }

    public double getPrixRepas() {
        return prixRepas;
    }

    public void setPrixRepas(double prixRepas) {
        this.prixRepas = prixRepas;
    }

    public int getStockDisponible() {
        return stockDisponible;
    }

    public void setStockDisponible(int stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

    public boolean getCommande() {
        return commande;
    }

    public void setCommande(boolean commande) {
        this.commande = commande;
    }
   // Getter pour récupérer le stock précédent
public int getStockPrecedent() {
    return stockPrecedent;
}


    // Nouvelle méthode pour définir l'état précédent du stock
    public static void setStockPrecedent(int stockPrecedent) {
        Repas.stockPrecedent = stockPrecedent;
    }
 // Méthode pour initialiser la liste des repas avec des valeurs par défaut
static {
    repas.add(new Repas(1, null, "Repas A", 15.0, STOCK_INITIAL_REPAS, STOCK_INITIAL_REPAS));
    repas.add(new Repas(2, null, "Repas B", 12.5, STOCK_INITIAL_REPAS, STOCK_INITIAL_REPAS));
}


    // Méthode pour sauvegarder les repas dans un fichier
    public static void sauvegarderRepas() {
        sauvegarderListeDansFichier(repas, FICHIER_REPAS);
    }

    // Méthode pour commander les repas choisis
    public static void commanderRepas(List<Repas> repasChoisis) {
        if (!repasChoisis.isEmpty()) {
            for (Repas repas : repasChoisis) {
                commanderRepas(repas);
            }
            sauvegarderRepas();
        }
    }

    // Nouvelle méthode pour commander un repas spécifique
    // Méthode pour commander un repas spécifique
private static void commanderRepas(Repas repas) {
    if (repas.getStockDisponible() > 0) {
        System.out.println("Repas commandé : " + repas.getTypeRepas() +
                " (Prix : " + repas.getPrixRepas() +
                " | Stock disponible : " + repas.getStockDisponible() + ")");
        repas.setStockDisponible(repas.getStockDisponible() - 1);
        repas.setCommande(true);
        
        // Mettez à jour le stock précédent après chaque commande
        stockPrecedent = repas.getStockDisponible();
        sauvegarderRepas(); // Sauvegardez l'état actuel après chaque commande
    } else {
        System.out.println("Désolé, le repas " + repas.getTypeRepas() + " est en rupture de stock.");
    }
}
    // Méthode pour afficher les repas disponibles
    public static void afficherRepas() {
        System.out.println("Liste des repas disponibles :");
        for (Repas repas : repas) {
            System.out.println("ID : " + repas.getIdRepas() + " - " + repas.getTypeRepas() +
                    " (Prix : " + repas.getPrixRepas() + " | Stock disponible : " + repas.getStockDisponible() + ")");
        }
    }

   // Dans la classe Repas, modifiez la méthode ajouterRepas() comme suit :
public static Repas ajouterRepas() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Entrez le type de repas : ");
    String typeRepas = scanner.nextLine();

    System.out.println("Entrez le prix du repas : ");
    double prixRepas = scanner.nextDouble();

    
    // Utilisez une valeur par défaut ou une valeur fixe pour le stock
    int stockDisponible = 10; 
    Repas nouveauRepas = new Repas(getProchainIdRepas(), null, typeRepas, prixRepas, stockDisponible,stockPrecedent);

    repas.add(nouveauRepas);
    sauvegarderRepas();

    System.out.println("Repas ajouté avec succès !");

    return nouveauRepas;
}

// Ajoutez également une méthode pour obtenir le prochain ID de repas disponible :
private static int getProchainIdRepas() {
    if (repas.isEmpty()) {
        return 1; // Si la liste est vide, commencez avec l'ID 1
    } else {
        return repas.get(repas.size() - 1).getIdRepas() + 1; // Utilisez l'ID du dernier repas + 1
    }
}


    public void annulerCommandeRepas() {
        // Marquer le repas comme non commandé
        this.setCommande(false);
        if (client == null) {
            System.out.println("Le repas spécifié n'est pas commandé. Impossible d'annuler la commande.");
        } else {
            System.out.println("Annulation de la commande du repas : " + typeRepas);
            // Réinitialiser le client associé au repas (à adapter selon votre logique)
            this.client = null;
            // Augmenter le stock après l'annulation de la commande
            this.stockDisponible++;
            this.commande = false;
            sauvegarderRepas();
            System.out.println("Commande du repas annulée avec succès.");
        }
    }

    public static List<Repas> getListeRepas() {
        return new ArrayList<>(repas);
    }

    // Méthode pour initialiser la liste des repas avec des valeurs par défaut
static {
    repas.add(new Repas(1, null, "Repas A", 15.0, stockPrecedent, STOCK_INITIAL_REPAS));
    repas.add(new Repas(2, null, "Repas B", 12.5, stockPrecedent,STOCK_INITIAL_REPAS));
}


    // Nouvelle méthode pour charger les repas depuis un fichier
    public static void chargerRepas() {
        List<Repas> repasTemp = new ArrayList<>(repas);
        chargerListeDepuisFichier(FICHIER_REPAS, repas);
        if (repas.isEmpty()) {
            repas.clear();
            repas.addAll(repasTemp);
    
            // Mettez à jour le stock précédent en fonction des commandes passées
            stockPrecedent = repasTemp.stream().mapToInt(Repas::getStockDisponible).min().orElse(STOCK_INITIAL_REPAS);
            
            System.out.println("Chargement des repas depuis le fichier a échoué. Restauration des données précédentes.");
        } else {
            System.out.println("Liste des repas après chargement :");
            for (Repas repas : repas) {
                System.out.println(repas);
            }
        }
    }

    private static <T extends Serializable> void chargerListeDepuisFichier(String nomFichier, List<T> liste) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomFichier))) {
            liste.clear();
            List<T> listeChargee = (List<T>) ois.readObject();
            liste.addAll(listeChargee);
            System.out.println("L'etat de l'hotel a été chargé avec succès !");
        } catch (EOFException e) {
            System.out.println("Le fichier " + nomFichier + " est vide.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erreur lors du chargement de l'etat de l'hote : " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "ID : " + idRepas + ", Type : " + typeRepas + ", Prix : " + prixRepas + ", Stock disponible : " + stockDisponible;
    }

    private static <T extends Serializable> void sauvegarderListeDansFichier(List<T> liste, String nomFichier) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomFichier))) {
            oos.writeObject(liste);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde de l'état de l'hôtel : " + e.getMessage());
        }
    }
}
