package Smart_Home_Systeme;

import java.util.ArrayList;

public class Maison {
    private Meteo meteo;
    private double temperature;
    private double humidite;
    private String luminosite;
    private double consommationtotale;
    private Equipements_domestiques douche;
    private Equipements_domestiques lampes;
    private Equipements_domestiques four;
    private Equipements_domestiques television;
    private ArrayList<Equipements_energetiques> tab_EE;


    public Maison(Meteo met){
        this.meteo = met;
        this.temperature = 23;
        this.humidite = 55;
        this.luminosite = "";
        this.consommationtotale = 0;
        this.douche = new Equipements_domestiques("Douche", 200, false);
        this.lampes = new Equipements_domestiques("Lampes", 100, false);
        this.television = new Equipements_domestiques("Television", 50, false);
        this.four = new Equipements_domestiques("Four", 20, false);
        this.tab_EE = new ArrayList<>(9);
    }

    public double getHumidite() {
        return humidite;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temp) {
        this.temperature += temp;
    }

    public void setHumidite(double hum) {
        this.humidite += hum;
    }

    public void ModifieMaison(Meteo meteo1){
        if (temperature > meteo.getTemperature() && meteo.getTemperature() > 30){
            this.temperature += 3;
            this.humidite -= 5;
        } else if (temperature < meteo.getTemperature() && meteo.getTemperature() < 0){
            this.temperature -= 3;
            this.humidite += 5;
        } else if (meteo.getTemperature() >= 0 && meteo.getTemperature() < 15) {
            this.temperature -= 1;
            this.humidite += 1;
        } else if (meteo.getTemperature() >= 15 && meteo.getTemperature() <= 30) {
            this.temperature += 1;
            this.humidite -= 1;
        }
    }

    public ArrayList<Equipements_energetiques> getTab_EE() {
        return tab_EE;
    }

    public void calculConsommationtotale() {
        for (Equipements_energetiques EE : tab_EE){
            consommationtotale += EE.getConsommation();
        }
        consommationtotale += douche.getConsommation() + lampes.getConsommation() + four.getConsommation() + television.getConsommation();
    }

    public void setConsommationtotale(double conso) {
        this.consommationtotale = conso;
    }

    public double getConsommationtotale() {
        return consommationtotale;
    }

    public Equipements_domestiques getDouche(){
        return douche;
    }

    public Equipements_domestiques getLampes(){
        return lampes;
    }

    public Equipements_domestiques getFour(){
        return four;
    }

    public Equipements_domestiques getTelevision(){
        return television;
    }

    public boolean bonneTemperature() {
        if (temperature <= 30 && temperature >= 13){
            return true;
        } else {
            return false;
        }
    }

    public boolean bonneHumidite() {
        if (humidite <= 70 && humidite >= 40){
            return true;
        } else {
            return false;
        }
    }

    public void setLuminosite(){
        if (meteo.getBTactive() && !meteo.getMTactive()){
            this.luminosite = "Il fait beau temps, les lampes peuvent être éteintes";
        }
        if (!meteo.getBTactive() && meteo.getMTactive()){
            this.luminosite = "Il fait mauvais temps, les lampes peuvent être allumées";
        }
    }

    public String getLuminosite(){
        return luminosite;
    }

    public Meteo getMeteo() {
        return meteo;
    }

}


