package Smart_Home_Joueur;

import Smart_Home_Systeme.Equipements_energetiques;
import Smart_Home_Systeme.Maison;

public class Joueur {
    private int nombre_jour_survie;
    private String pseudo;
    private double argent;

    public Joueur(){
        this.nombre_jour_survie = 0;
        this.pseudo = "Player";
        this.argent = 25000.0;
    }

    public Joueur(int nb, String p, double a){
        this.nombre_jour_survie = nb;
        this.pseudo = p;
        this.argent = a;
    }
    public void acheterEquipement(Equipements_energetiques equipement, Maison maison) {
        double prix = equipement.getPrix();
        if (prix > this.argent) {
            System.out.println("Vous n'avez pas assez d'argent pour acheter cet équipement");
        } else {
            this.argent -= prix;
            maison.setEquipement_energetique(equipement);
            System.out.println("L'équipement a été acheté avec succès et ajouté à la maison");
        }
    }

    public void abandonner() {
        System.out.println("Fin de la partie");
        System.exit(0);
    }
    public void lancerPartie() {
        System.out.println("Bienvenue frero tu t'appeles  " + this.pseudo + " et t'as " + this.argent + "€, bonne chance pour survivre dans cette maison de merde ");
    // reste du code a faire

    }
}
