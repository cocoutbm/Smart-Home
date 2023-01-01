import Smart_Home_Systeme.*;

import java.util.Random;

public class Main {
    public static void main(String [] args) throws InterruptedException {
        Equipements_domestiques douche = new Equipements_domestiques("Douche", 100);
        Equipements_domestiques lampes = new Equipements_domestiques("Lampes", 100);
        Equipements_domestiques four = new Equipements_domestiques("Four", 100);
        Equipements_domestiques television = new Equipements_domestiques("Television", 100);
        Equipements_energetiques Radiateur1 = new Equipements_energetiques("Radiateur lowcost", 150.0, 100.0, false);
        Equipements_energetiques Radiateur2 = new Equipements_energetiques("Radiateur populaire", 250.0, 150.0, false);
        Equipements_energetiques Radiateur3 = new Equipements_energetiques("Radiateur haut de' gamme", 350.0, 200.0, false);
        Equipements_energetiques Ventilateur1 = new Equipements_energetiques("Ventilateur lowcost", 25.0, 50.0, false);
        Equipements_energetiques Ventilateur2 = new Equipements_energetiques("Ventilateur populaire", 65.0, 100.0, false);
        Equipements_energetiques Ventilateur3 = new Equipements_energetiques("Ventilateur haut de gamme", 100.0, 150.0, false);
        Equipements_energetiques Ampoule1 = new Equipements_energetiques("Ampoule lowcost", 3.5, 10.0, false);
        Equipements_energetiques Ampoule2 = new Equipements_energetiques("Ampoule populaire", 7.5, 20.0, false);
        Equipements_energetiques Ampoule3 = new Equipements_energetiques("Ampoule haut de gamme", 14.5, 30.0, false);

        Maison Smart_Home = new Maison(23, 55, 500, douche, lampes, four, television, Radiateur1, Radiateur2, Radiateur3, Ventilateur1, Ventilateur2, Ventilateur3, Ampoule1, Ampoule2, Ampoule3);
        Smart_Home.showMaison();

        Random random = new Random();
        Meteo meteo = new Meteo();
        MauvaisTemps mauvaisTemps = new MauvaisTemps();
        BonTemps bonTemps = new BonTemps();
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(30000); // pause de 30 secondes
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int choix = random.nextInt(2); // choix aléatoire entre 0 et 1
                if (choix == 0) { // Mauvais temps est choisi et on modifie la valeur de Meteo
                    mauvaisTemps.diminueTemperature();
                    mauvaisTemps.augmenteHumidite();
                    meteo.setTemperature(mauvaisTemps.getTemperature());
                    meteo.setHumidite(mauvaisTemps.getHumidite());
                } else { // Bon Temps est choisi et on modifie la valeur de Meteo
                    bonTemps.augmenteTemp();
                    bonTemps.diminueHum();
                    meteo.setTemperature(bonTemps.getTemperature());
                    meteo.setHumidite(bonTemps.getHumidite());
                }
            }
        });

        thread.start();
    }



    }
