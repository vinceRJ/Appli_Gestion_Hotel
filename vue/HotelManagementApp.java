//  Classe principale pour l'interface utilisateur, elle fait appel au methode du controlller
// Objectif est de respecte le modele MVC(Modele-Vue-Controlleur)

package vue;

import controller.HotelController;
import model.Repas;

public class HotelManagementApp {
    private final HotelController controller;
    
    public HotelManagementApp() {
        this.controller = new HotelController();
        // Initialisation de l'interface utilisateur
    }

    public void run() {
        //controller.creerChambreNormal();
        //controller.creerChambreDeLuxe();
        //controller.chargerChambreNormal();
        //controller.chargerChambreDeLuxe();
        ///controller.afficherMenuPrincipal();
        //controller.creerClient();
        
        controller.afficherMenuPrincipal();
    }

    public static void main(String[] args) {
        Repas repasInstance = new Repas();  // Créez une instance de Repas
    int stockPrecedent = repasInstance.getStockPrecedent();  // Utilisez l'instance pour appeler la méthode
    Repas.chargerRepas();

    // Après avoir chargé les repas depuis le fichier
    repasInstance.setStockPrecedent(stockPrecedent);
    HotelManagementApp app = new HotelManagementApp();
    app.run();
    }
}
