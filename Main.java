import Smart_Home_Joueur.Joueur;
import Smart_Home_Systeme.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String [] args){
        ArrayList<Equipements_energetiques> zgeg = new ArrayList<>();

        Maison maison1 = new Maison(zgeg);
        Meteo meteo = new Meteo();
        BonTemps bontemps = new BonTemps();
        MauvaisTemps mauvaistemps = new MauvaisTemps();
        Random random = new Random();
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(3000); // pause de 30 secondes
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int choix = random.nextInt(2); // choix aléatoire entre 0 et 1
                if (choix == 0) { // mauvais temps
                    mauvaistemps.ModifieMauvaisTemps();
                    meteo.ModifieMeteoMT(mauvaistemps);
                    maison1.ModifieMaison(meteo);
                    System.out.println(maison1.getTemperature());
                } else { //bon temps
                    bontemps.ModifieBonTemps();
                    meteo.ModifieMeteoBT(bontemps);
                    maison1.ModifieMaison(meteo);
                    System.out.println(maison1.getTemperature());
                }
            }
        });

        thread.start();




    }






}
