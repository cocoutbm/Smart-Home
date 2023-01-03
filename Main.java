import Smart_Home_Joueur.Joueur;
import Smart_Home_Systeme.Boutique;
import Smart_Home_Systeme.Equipements_domestiques;
import Smart_Home_Systeme.Equipements_energetiques;
import Smart_Home_Systeme.Maison;

import java.util.ArrayList;

public class Main {
    public static void main(String [] args){

        Joueur jc = new Joueur();
        Boutique bou = new Boutique();
        ArrayList<Equipements_energetiques> tab = new ArrayList<>();
        tab.add(jc.AcheterEquip(bou));
        tab.add(jc.AcheterEquip(bou));
        tab.add(jc.AcheterEquip(bou));

        Maison Smart_Home = new Maison(tab);
        Smart_Home.showMaison();
        System.out.println(jc.getArgent());
    }
}