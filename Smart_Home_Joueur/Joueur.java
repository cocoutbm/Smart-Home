package Smart_Home_Joueur;

import Smart_Home_Systeme.Boutique;
import Smart_Home_Systeme.Equipements_energetiques;

import java.util.Scanner;

public class Joueur {
    private int nombre_jour_survie;
    private String pseudo;
    private double argent;
    private Boutique boutique;

    public Joueur(){
        this.nombre_jour_survie = 0;
        this.pseudo = "Player";
        this.argent = 25000.0;
        this.boutique = new Boutique();
    }

    public Joueur(int nb, String p, double a, Boutique b){
        this.nombre_jour_survie = nb;
        this.pseudo = p;
        this.argent = a;
        this.boutique = b;
    }

    public double getArgent() {
        return argent;
    }

    public Equipements_energetiques AcheterEquip(Boutique b) {
        Equipements_energetiques EE = new Equipements_energetiques();
        Scanner sc = new Scanner(System.in);

        System.out.println("Quel Équipement Énergétique souhaitez vous prendre ?");
        System.out.println("    R1/ Radiateur lowcost");
        System.out.println("    R2/ Radiateur populaire");
        System.out.println("    R3/ Radiateur haut de gamme");
        System.out.println("    V1/ Ventilateur lowcost");
        System.out.println("    V2/ Ventilateur populaire");
        System.out.println("    V3/ Ventilateur haut de gamme");
        System.out.println("    A1/ Ampoule qualite 1");
        System.out.println("    A2/ Ampoule qualite 2");
        System.out.println("    A3/ Ampoule qualite 3 \n");

        System.out.print("Saisissez votre choix : ");
        String choix = sc.nextLine();

        switch (choix) {
            case "R1":
                EE = b.getRadiateur1();
                break;
            case "R2":
                EE = b.getRadiateur2();
                break;
            case "R3":
                EE = b.getRadiateur3();
                break;
            case "V1":
                EE = b.getVentilateur1();
                break;
            case "V2":
                EE = b.getVentilateur2();
                break;
            case "V3":
                EE = b.getVentilateur3();
                break;
            case "A1":
                EE = b.getAmpoule1();
                break;
            case "A2":
                EE = b.getAmpoule2();
                break;
            case "A3":
                EE = b.getAmpoule3();
                break;
        }

        this.argent -= EE.getPrix();
        return EE;
    }
}
