//  Classe principale pour l'interface utilisateur, elle fait appel au methode du controlller
// Objectif est de respecte le modele MVC(Modele-Vue-Controlleur)

package vue;

import controller.HotelController;

public class HotelManagementApp {
    private final HotelController controller;

    public HotelManagementApp() {
        this.controller = new HotelController();
        // Initialisation de l'interface utilisateur
    }

    public void run() {
        //controller.creerChambreNormal();
        //controller.creerChambreDeLuxe();
        controller.chargerChambreNormal();
        controller.chargerChambreDeLuxe();
        controller.afficherDetailsChambres();
    }

    public static void main(String[] args) {
        HotelManagementApp app = new HotelManagementApp();
        app.run();
    }
}
