package Smart_Home_Systeme;

import java.util.ArrayList;

//classe définissant une maison
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

    //constructeur de Maison par défaut
    public Maison(Meteo met){
        this.meteo = met;
        this.temperature = 23;
        this.humidite = 55;
        this.luminosite = "temps neutre";
        this.consommationtotale = 0;
        this.douche = new Equipements_domestiques("Douche", 200, false);
        this.lampes = new Equipements_domestiques("Lampes", 100, false);
        this.television = new Equipements_domestiques("Television", 50, false);
        this.four = new Equipements_domestiques("Four", 20, false);
        this.tab_EE = new ArrayList<>(9);
    }

    public ArrayList<Equipements_domestiques> setTab_ED() {
        ArrayList<Equipements_domestiques> tab_ED = new ArrayList<>(4);
        tab_ED.add(douche);
        tab_ED.add(lampes);
        tab_ED.add(television);
        tab_ED.add(four);
        return tab_ED;
    }

    //methode permettant de récuperer l'humidité
    public double getHumidite() {
        return humidite;
    }

    //methode permettant de récuperer la temperature
    public double getTemperature() {
        return temperature;
    }

    //methode permettant de modifier la temperature
    public void setTemperature(double temp) {
        this.temperature += temp;
    }
    //methode permettant de modifier l'humidité
    public void setHumidite(double hum) {
        this.humidite += hum;
    }
    //methode permettant de modifier la maison
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
    //methode permettant de retourner la liste des equipements achetés
    public ArrayList<Equipements_energetiques> getTab_EE() {
        return tab_EE;
    }
    //methode permettant de calculer la consommation totale de la maison (conso domestique + energetique)
    public void calculConsommationtotale() {
        for (Equipements_energetiques EE : tab_EE){
            consommationtotale += EE.getConsommation();
        }
        consommationtotale += douche.getConsommation() + lampes.getConsommation() + four.getConsommation() + television.getConsommation();
    }
    //methode permettant de modifier la consommation totale de la maison
    public void setConsommationtotale(double conso) {
        this.consommationtotale = conso;
    }
    //methode permettant de retourner la consommation totale de la maison
    public double getConsommationtotale() {
        return consommationtotale;
    }
    //methode permettant de retourner la douche
    public Equipements_domestiques getDouche(){
        return douche;
    }
    //methode permettant de retourner la lampe
    public Equipements_domestiques getLampes(){
        return lampes;
    }
    //methode permettant de retourner le four
    public Equipements_domestiques getFour(){
        return four;
    }
    //methode permettant de retourner la television
    public Equipements_domestiques getTelevision(){
        return television;
    }
    //methode permettant de retourner si la temperature est bonne ou non
    public boolean bonneTemperature() {
        if (temperature <= 30 && temperature >= 13){
            return true;
        } else {
            return false;
        }
    }
    //methode permettant de retourner si l'humidité est bonne ou non
    public boolean bonneHumidite() {
        if (humidite <= 70 && humidite >= 40){
            return true;
        } else {
            return false;
        }
    }
    //methode permettant de retourner si l'humidité est bonne ou non
    public void setLuminosite(){
        if (meteo.getBTactive() && !meteo.getMTactive()){
            this.luminosite = "Il fait beau temps, les lampes peuvent être éteintes";
        }
        if (!meteo.getBTactive() && meteo.getMTactive()){
            this.luminosite = "Il fait mauvais temps, les lampes peuvent être allumées";
        }
    }
    //methode permettant de retourner la luminosité
    public String getLuminosite(){
        return luminosite;
    }
    //methode permettant de retourner la météo
    public Meteo getMeteo() {
        return meteo;
    }



}


