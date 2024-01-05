
// Classe responsable de la coordination
//La classe HotelController est responsable de la gestion 
//du flux de contrôle, de la logique d'affichage, et de 
//la coordination des actions entre la vue et le modèle. 
//Cela contribue à une meilleure séparation des préoccupations 
//et à une structure 

package controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import model.Client;
import model.Chambre;
import model.ChambreDeLuxe;
import model.ChambreNormale; 
import model.Reservation;
import model.Repas;
import model.Reservable;
import model.Facture;
import java.io.*;



public class HotelController {
private final Scanner scanner;
private Client newClient;
private ChambreDeLuxe newChambreDeLuxe;
private ChambreNormale newChambreNormale;
private Repas newRepas; ///j'ai ajputer cette attribut

public HotelController() {
this.scanner = new Scanner(System.in);
this.newClient = new Client();
this.newChambreDeLuxe = new ChambreDeLuxe();
this.newChambreNormale = new ChambreNormale();
this.newRepas = new Repas(); //j'ai ajouter ça aussi dans le contructeur 
//Repas.initialiserRepas();
Repas.sauvegarderRepas(); 
}


public void afficherMenuPrincipal() {
    int choixMenu = 0;

    do {
        try {
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Les chambres");
            System.out.println("2. Effectuer une réservation (en cours d'implémentation)");
            System.out.println("3. Modifier une réservation (pas encore implémenté)");
            System.out.println("4. Annuler une réservation (pas encore implémenté)");
            System.out.println("5. Commander un repas (pas encore implémenté)");
            System.out.println("6. Enregistrer la facture (pas encore implémenté)");
            System.out.println("7. Options client");
            System.out.println("8. Options repas");
            System.out.println("9. Quitter");
            System.out.print("Choisissez une option : ");

            choixMenu = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne après la saisie

            traiterChoixMenuPrincipal(choixMenu); // Traiter le choix de l'utilisateur

        } catch (InputMismatchException e) {
            System.out.println("Veuillez entrer un nombre entier valide.");
            scanner.next(); // Consommer l'entrée incorrecte pour éviter une boucle infinie
        }
    } while (choixMenu != 9);
}

private void traiterChoixMenuPrincipal(int choix1) {
switch (choix1) {
case 1:
menuGestionChambre();
break;
case 2:
/*/ creation client
Client clientcree = new Client();
clientcree.creerClient();
Chambre chambreChoisi = choixChambre();
String laDateDebut = demanderDateDebut(); 
String laDateFin = demanderDateFin(); 
effectuerReservation(clientcree, chambreChoisi, laDateDebut, laDateFin);
afficherReservation();*/
break;
case 3:
//modifierReservation();
break;
case 4:
// annulerReservation();
break;
case 5:
commanderRepas();
break;
case 6:
enregistrerFacture();
break;
case 7:
optionClient();
break;
case 8:
//option 8
optionRepas();
//System.out.println("MET TA METHODE ICI");
break;
case 9:
System.out.println("Fin du programme !");
break;
default:
System.out.println("Option non valide. Veuillez réessayer.");
}
}

//----------------------------------------------------------------Gesttion des chambre ----------------------------------------------------------------
// methode afficher les option des chambres (choix 1)
public void menuGestionChambre(){

int choix2;
do{
System.out.println("=== Menu de gestion de chambre ===\n1. Afficher les détails des chambres\n2. Afficher la disponibilité des chambres\n3. Ajouter une chambre à l'hotel");
System.out.println("4. Quitter le menu client");
System.out.print("Choisissez une option : \n=> ");
choix2 = scanner.nextInt();
scanner.nextLine(); 
newChambreDeLuxe.chargerChambreDeLuxe();
newChambreNormale.chargerChambreNormal();

traiterOptionChambre(choix2);

} while (choix2 != 4);
}
//traitement du menu chambre 
private void traiterOptionChambre(int choix3) {
switch (choix3) {
case 1:
afficherDetailsChambres();
break;
case 2:
afficherDisponibilitesChambres();
break;
case 3:
ajouterChambre();
break;
case 4:
System.out.println("Au revoir !");
break;
} 
}

public void afficherDetailsChambres() {
Scanner scanner = new Scanner(System.in);
System.out.println("Choisissez le type de chambre à afficher :");
System.out.println("1. Chambre de luxe ");
System.out.println("2. Chambre Normaux");
System.out.println("3. Quitter ce menu ");
System.out.print("Choisissez une option : \n=> ");

int choix4 = scanner.nextInt();
switch (choix4) {
case 1:
newChambreDeLuxe.afficherChambresDeLuxe();
break;
case 2:
newChambreNormale.afficherChambresNormales();
break;
case 3:
System.out.println("Au revoir !");
break;
default:
System.out.println("Votre choix est invalide");
}
}

private void afficherDisponibilitesChambres() {
Scanner scanner = new Scanner(System.in);

System.out.println("Vous voulez voir les disponibilites de quel type de chambre");
System.out.println("1. Chambre de luxe ");
System.out.println("2. Chambre Normaux");
System.out.println("3. Quitter ce menu ");
System.out.print("Choisissez une option : \n=> ");

int choix = scanner.nextInt();
switch (choix) {
case 1:
newChambreDeLuxe.disponibilitesChambresDeLuxe();
break;
case 2:
newChambreNormale.disponibilitesChambresNormales();
break;

case 3:
System.out.println("Au revoir !");
break;
default:
System.out.println("Votre choix est invalide");
}

}

private void ajouterChambre(){
Scanner scanner = new Scanner(System.in);

System.out.println("Vous voulez ajouter quel type de chambre");
System.out.println("1. Chambre de luxe ");
System.out.println("2. Chambre Normaux");
System.out.println("3. Quitter ce menu ");
System.out.print("Choisissez une option : \n=> ");
int choix = scanner.nextInt();
switch (choix) {
case 1:
newChambreDeLuxe.creerChambreDeLuxe();
break;
case 2:
newChambreNormale.creerChambreNormale();
break;
case 3:
System.out.println("Au revoir !");
break;
default:
System.out.println("Votre choix est invalide");
} 
}
//---------------------------------------------------------------- Fin gestion des chambres ----------------------------------------------------------------

///--------------------------------------Début de gestion des repas et logique----------------------

            // Choix 8 - Options repas
private void optionRepas() {
    int choix;
    do {
        System.out.println("=== Options Repas ===");
        System.out.println("**************Bienvenue dans la rubrique choix des repas. Quelques repas sont proposés************");
        System.out.println("1. Afficher la liste des repas");
        System.out.println("2. Commander un repas");
        System.out.println("3. Annuler une commande de repas");
        System.out.println("4. Quitter le menu repas");
         System.out.println("5.Ajouter iun repas");

        System.out.print("Choisissez une option : ");
        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide.");
            scanner.next(); // Consommer l'entrée incorrecte
        }
        choix = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne après la saisie du choix

        traiterOptionRepas(choix);
    } while (choix != 5);
}


private void ajouterRepas() {
    Repas.ajouterRepas();
}

// Traitement du menu repas
private void traiterOptionRepas(int choix) {
    switch (choix) {
        case 1:
            System.out.println("Afficher la liste des repas :");
            // Charger et afficher la liste des repas
            Repas.chargerRepas();
            List<Repas> repasList = Repas.getListeRepas();
            for (Repas repas : repasList) {
                System.out.println("ID : " + repas.getIdRepas() + ", Type : " + repas.getTypeRepas() + ", Prix : " + repas.getPrixRepas());
            }

            // Demander à l'utilisateur de choisir un repas par ID
            int idRepasChoisi;
            do {
                System.out.print("Entrez le numéro du repas que vous souhaitez choisir : ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Veuillez entrer un nombre valide.");
                    scanner.next(); // Consommer l'entrée incorrecte
                }
                idRepasChoisi = scanner.nextInt();
                scanner.nextLine(); // Consommer la nouvelle ligne après la saisie
                if (idRepasChoisi <= 0 || idRepasChoisi > repasList.size()) {
                    System.out.println("Numéro de repas non valide. Veuillez réessayer.");
                }
            } while (idRepasChoisi <= 0 || idRepasChoisi > repasList.size());

            Repas repasChoisi = rechercherRepasParNumero(idRepasChoisi);

            if (repasChoisi != null) {
                System.out.println("Vous avez choisi le repas : " + repasChoisi.getTypeRepas());

                // Demander à l'utilisateur s'il veut commander ce repas
                int choixCommande;
                do {
                    System.out.print("Voulez-vous commander ce repas ? (1 pour Oui, 2 pour Non) : ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Veuillez entrer un nombre valide.");
                        scanner.next(); // Consommer l'entrée incorrecte
                    }
                    choixCommande = scanner.nextInt();
                    scanner.nextLine(); // Consommer la nouvelle ligne après la saisie
                    if (choixCommande != 1 && choixCommande != 2) {
                        System.out.println("Veuillez entrer 1 pour Oui ou 2 pour Non.");
                    }
                } while (choixCommande != 1 && choixCommande != 2);

                if (choixCommande == 1) {
                    // Commander le repas
                    commanderRepas(repasChoisi);
                }
            } else {
                System.out.println("Numéro de repas non valide.");
            }
            break;
        case 2:
            // Commander un repas
            commanderRepas();
            break;
        case 3:
            // Annuler une commande de repas
            annulerCommandeRepas();
            break;
        case 4:
            System.out.println("Au revoir !");
            break;
        case 5:
            ajouterRepas();
            break;
        default:
            System.out.println("Option non valide. Veuillez réessayer.");
    }
}

// Méthode pour commander un repas
// choix 2
// Méthode pour commander un repas
private void commanderRepas() {
    boolean repasCommande = false;
    do {
        // Afficher la liste des repas
        Repas.chargerRepas();

        // L'utilisateur choisit un repas en entrant le numéro
        int numeroRepas;
        do {
            System.out.print("Entrez le numéro du repas que vous souhaitez commander (ou 0 pour quitter) : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide.");
                scanner.next(); // Consommer l'entrée incorrecte
            }
            numeroRepas = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne après la saisie
            if (numeroRepas < 0 || numeroRepas > Repas.getListeRepas().size()) {
                System.out.println("Numéro de repas non valide. Veuillez réessayer.");
            }
        } while (numeroRepas < 0 || numeroRepas > Repas.getListeRepas().size());

        if (numeroRepas == 0) {
            // L'utilisateur veut quitter
            break;
        }

        // Recherche du repas choisi parmi les repas
        Repas repasChoisi = rechercherRepasParNumero(numeroRepas);

        if (repasChoisi != null) {
            // Afficher le récapitulatif de la commande
            System.out.println("Vous avez commandé : " + repasChoisi.getTypeRepas() + " (Prix : " + repasChoisi.getPrixRepas() + ")");
            // Commander le repas choisi
            commanderRepas(repasChoisi);
            repasCommande = true;
        } else {
            System.out.println("Numéro de repas non valide. Veuillez réessayer.");
        }
    } while (!repasCommande);
}

// Méthode pour commander un repas spécifique
private void commanderRepas(Repas repas) {
    if (repas != null) {
        if (repas.getStockDisponible() > 0) {
            System.out.println("Vous avez commandé : " + repas.getTypeRepas() + " (Prix : " + repas.getPrixRepas() + ")");
            
            // Mise à jour du statut de commande
            repas.setCommande(true);
            
            // Mise à jour du stock
            repas.setStockDisponible(repas.getStockDisponible() - 1);
            
            // Sauvegarde des repas (si nécessaire)
            Repas.sauvegarderRepas();
        } else {
            System.out.println("Désolé, le repas est en rupture de stock.");
        }
    } else {
        System.out.println("Le repas spécifié est null. Impossible de commander.");
    }
}


// Méthode pour annuler une commande de repas
// choix 3
private void annulerCommandeRepas(int idRepas) {
    Repas repasChoisi = rechercherRepasParNumero(idRepas);

    if (repasChoisi != null) {
        System.out.println("Annulation de la commande du repas : " + repasChoisi.getTypeRepas());
        // Ajoutez ici la logique spécifique à l'annulation de la commande
        repasChoisi.annulerCommandeRepas();
        Repas.sauvegarderRepas(); // Sauvegarder les repas après l'annulation de la commande
    } else {
        System.out.println("Numéro de repas non valide. Impossible d'annuler la commande.");
    }
}


private void annulerCommandeRepas() {
    boolean repasAnnule = false;

    // Charger la liste des repas une seule fois avant d'entrer dans la boucle
    Repas.chargerRepas();

    do {
        // Afficher la liste des repas
        //Repas.afficherRepas();

        // L'utilisateur choisit un repas en entrant le numéro
        int numeroRepas;
        do {
            System.out.print("Entrez le numéro du repas que vous souhaitez annuler (ou 0 pour quitter) : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide.");
                scanner.next(); // Consommer l'entrée incorrecte
            }
            numeroRepas = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne après la saisie
            if (numeroRepas < 0 || numeroRepas > Repas.getListeRepas().size()) {
                System.out.println("Numéro de repas non valide. Veuillez réessayer.");
            }
        } while (numeroRepas < 0 || numeroRepas > Repas.getListeRepas().size());

        if (numeroRepas == 0) {
            // L'utilisateur veut quitter
            repasAnnule = true;
        } else {
            // Recherche du repas choisi parmi les repas
            Repas repasChoisi = rechercherRepasParNumero(numeroRepas);

            if (repasChoisi != null) {
                if (repasChoisi.getCommande()) {
                    System.out.println("Annulation de la commande du repas : " + repasChoisi.getTypeRepas());
                    // Ajoutez ici la logique spécifique à l'annulation de la commande
                    repasChoisi.annulerCommandeRepas();
                    Repas.sauvegarderRepas(); // Sauvegarder les repas après l'annulation de la commande
                } else {
                    System.out.println("Le repas spécifié n'est pas commandé. Impossible d'annuler la commande.");
                }
            } else {
                System.out.println("Numéro de repas non valide. Impossible d'annuler la commande.");
            }
        }
    } while (!repasAnnule);
}







// Méthode pour rechercher un repas par son numéro
private Repas rechercherRepasParNumero(int numeroRepas) {
    List<Repas> repasList = Repas.getListeRepas();
    for (Repas repas : repasList) {
        if (repas.getIdRepas() == numeroRepas) {
            return repas;
        }
    }
    return null;
}

            ///---------------------------------------------Fin gestion des repas--------------------------------

            // choix 6
            private void enregistrerFacture() {
            }
            // methode pour gere menu option client (choix 8)
            public void optionClient(){

            int choix;
            do {
            System.out.println("=== Option Client ===\n1. Creer un client\n2. Afficher la liste de clients\n3. Modifier client");
            System.out.println("3. Modifier client (pas encore implementé)");
            System.out.println("4. Afficher resevation de clients (pas encore implementé)");
            System.out.println("5. Quitter le menu client");
            System.out.print("Choisissez une option : ");

            choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne après la saisie du choix

            traiterOptionClient(choix);
            } while (choix != 5);
            }

            //traitement du menu option client 
            private void traiterOptionClient(int choix) {
            switch (choix) {
            case 1:
            newClient.creerClient();
            break;
            case 2:
            Client.chargerClients();
            Client.listeClient();
            break;
            case 3:
            //a definir
            break;
            case 4:
            // a definir 
            break;
            case 5:
            System.out.println("Au revoir !");
            break;
            }
            }

            public Chambre choixChambre(){
            Scanner scanner = new Scanner(System.in);

            newChambreDeLuxe.afficherChambresDeLuxe();
            newChambreNormale.afficherChambresNormales();

            // l'utilisateur choisit une chambre en entrant le numéro
            System.out.println("Entrez le numéro de la chambre que vous souhaitez réserver : ");
            int numeroChambreChoisi = scanner.nextInt();

            // Recherche de la chambre choisie parmi les chambres de luxe
            for (ChambreDeLuxe chambreDeLuxe : newChambreDeLuxe.getListChambreDeLuxe()) {
            if (chambreDeLuxe.getNumeroChambre() == numeroChambreChoisi) {
            return chambreDeLuxe;
            }
            }
            // Recherche de la chambre choisie parmi les chambres normales
            for (ChambreNormale chambreNormale : newChambreNormale.getListChambreNormale()) {
            if (chambreNormale.getNumeroChambre() == numeroChambreChoisi) {
            return chambreNormale;
            }
            }

            // cas ou le numero de chambre n'est pas valide
            System.out.println("Numéro de chambre non valide.");
            return null;
            }


//////////////////////////////////////////////// METHODE POUR lA RESERVATION /////////////////////////////////
/* Je finis ca bientot j'ai des erreurs 

private void effectuerReservation(Client client, Chambre chambre, String dateDebut, String dateFin) {
// generation d'un identifiant unique pour la reservation 
int idReservation = genererIdReservation();

// creation d'une instance de la reservation
Reservation reservation = new Reservation(idReservation, client, chambre, dateDebut, dateFin);
// utilisation de l'interface Reservable pour effectuer la reservation
if (chambre instanceof Reservable) {
// Vérification de la disponibilité de la chambre pour les dates spécifiées
if (chambre.getDisponible().equals("Oui")) { 
Reservable chambreReservable = (Reservable)chambre; // casting explicite 
chambreReservable.makeReservation(client, chambre, dateDebut, dateFin);

// ajout de la reservation dans la liste des reservations
ajouterReservation(reservation);

// Sauvegarde de la reservation
sauvegarderReservation();

// Mise à jour de l'état de la chambre
chambre.setDisponible(false);

System.out.println("La réservation a été effectuée avec succès. L'ID de réservation est : " + idReservation);
}
else{
System.out.println("La chambre n'est pas disponible pour MOMENT.");
}
}
else {
System.out.println("Cette chambre ne peut pas être réservée.");
}
}

public void afficherReservation() {
System.out.println("Les reservation sont :");
System.out.println("_________________________________________________________________________________________________________________________");
for (Reservation reservation : reservations) {
affichageReservation(reservation);
}
}

public String affichageReservation(Reservation reservation) {
return "Réservation #" + reservation.getIdReservation() + " :\n" +
"Client : " + reservation.getClient().getNom() + " (" + reservation.getClient().getNumeroTel() + ")\n" +
"Chambre : " + reservation.getChambre().getNumeroChambre() + " - " + reservation.getChambre().getTypeChambre() + "\n" +
"Dates du séjour : " + reservation.getDateDebut() + " au " + reservation.getDateFin();
}

public static String demanderDateDebut() {
Scanner scanner = new Scanner(System.in);
System.out.print("Entrez la date de début du séjour (format dd/MM/yyyy) : ");
String dateDebutString = scanner.next();
if (dateDebutString.isEmpty()) {
System.out.println("Veuillez saisir une date de début valide.");
return null;
}
return dateDebutString;
}
public static String demanderDateFin() {
Scanner scanner = new Scanner(System.in);
System.out.print("Entrez la date de fin du séjour (format dd/MM/yyyy) : ");
String dateFinString = scanner.next();
if (dateFinString.isEmpty()) {
System.out.println("Veuillez saisir une date de fin valide.");
return null;
}
return dateFinString;
} 

private void modifierReservation() {
// Logique pour modifier une réservation
}

private void annulerReservation() {
// Logique pour annuler une réservation
}

*/
}


