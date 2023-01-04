import Smart_Home_Joueur.Joueur;
import Smart_Home_Systeme.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String [] args){
        ArrayList<Equipements_energetiques> zgeg = new ArrayList<>();


        Maison maison1 = new Maison(zgeg);
        Meteo meteo = new Meteo();
        BonTemps bontemps = new BonTemps();
        MauvaisTemps mauvaistemps = new MauvaisTemps();
        Random random = new Random();
        Date date = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM");
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000); // pause de 3 secondes

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                int choix = random.nextInt(2); // choix aléatoire entre 0 et 1
                if (choix == 0) { // mauvais temps
                    mauvaistemps.ModifieMauvaisTemps();
                    meteo.ModifieMeteoMT(mauvaistemps);
                    maison1.ModifieMaison(meteo);

                } else { //bon temps
                    bontemps.ModifieBonTemps();
                    meteo.ModifieMeteoBT(bontemps);
                    maison1.ModifieMaison(meteo);
                }
                System.out.println(dateFormat.format(date) + " Temperature de la maison : " + maison1.getTemperature());
                System.out.println(dateFormat.format(date) + " Humidite de la maison : " + maison1.getHumidite());
                date.setTime(date.getTime() + 3600000); // avancer de 1h dans le jeu toute les 10seconde

            }
        });

        thread.start();




    }






}
