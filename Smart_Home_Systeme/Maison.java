package Smart_Home_Systeme;

import java.util.ArrayList;

public class Maison {
    private Meteo meteo;
    private float temperature;
    private float humidite;
    private float luminosite;
    private Equipements_domestiques douche;
    private Equipements_domestiques lampes;
    private Equipements_domestiques four;
    private Equipements_domestiques television;
    private ArrayList<Equipements_energetiques> tab_EE;


    public Maison(ArrayList<Equipements_energetiques> tab){
        this.temperature = 23;
        this.humidite = 55;
        this.luminosite = 500;
        this.douche = new Equipements_domestiques("Douche", 100);
        this.lampes = new Equipements_domestiques("Lampes", 100);
        this.four = new Equipements_domestiques("Four", 20);
        this.television = new Equipements_domestiques("Television", 50);
        this.tab_EE = tab;
    }

    public void showMaison(){
        System.out.println("Mesures Météo interne de la Smart Home");
        System.out.println(" Température: " + temperature + " °C.");
        System.out.println(" Humidité: " + humidite + " %.");
        System.out.println(" Luminosité: " + luminosite + " lux.");

        System.out.println("Équipements Domestiques de la Smart Home");
        douche.showEquipementsDomestiques();
        lampes.showEquipementsDomestiques();
        four.showEquipementsDomestiques();
        television.showEquipementsDomestiques();

        System.out.println("Équipements Énergétiques de la Smart Home");
        for(Equipements_energetiques EE : tab_EE){
            EE.showEquipementsEnergetiques();
        }
    }
    public float getHumidite() {
        return meteo.getHumidite();
    }

    public void setHumidite(float hum) {
        meteo.setHumidite(hum);
    }

    public float getTemperature() {
        return meteo.getTemperature();
    }
    public void setTemperature(float temp) {
        meteo.setHumidite(temp);
    }
}


