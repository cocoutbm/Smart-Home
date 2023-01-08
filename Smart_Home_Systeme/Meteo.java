package Smart_Home_Systeme;

//classe permettant de créer une météo 
public class Meteo {

    protected double humidite;                  //valeur de l'humidité de la météo
    protected double temperature;               //valeur de la temperature de la météo 
    private  boolean MTactive;                  //etat pour savoir si c'est un Mauvais Temps (True/False) 
    private boolean BTactive;                   //etat pour savoir si c'est un Bon Temps (True/False) 

//methode permettant creer une météo par defaut
    public Meteo(){
        this.humidite=55;
        this.temperature=23;
        this.MTactive = false;
        this.BTactive = true;
    }
    
//methode permettant creer une météo selon une humidité, une temperature
    public Meteo(double hum, double temp, boolean mtactive, boolean btactive){
        this.humidite=hum;
        this.temperature=temp;
        this.MTactive = mtactive;
        this.BTactive = btactive;
    }
    
//methode permettant de récuperer l'humidité d'une météo
    public double getHumidite() {
        return humidite;

    }
    
//methode permettant de changer l'humidité d'une météo
    public void setHumidite(double hum) {
        this.humidite = hum;
    }
    
//methode permettant de recuperer la temperature d'une météo
    public double getTemperature() {
        return temperature;
    }
    
//methode permettant de changer la temperature d'une météo
    public void setTemperature(double temp) {
        this.temperature = temp;
    }
    
//methode permettant de recuperer l'etat Mauvais Temps d'une météo
    public boolean getMTactive(){
        return MTactive;
    }
    
//methode permettant de recuperer l'etat Bon Temps d'une météo
    public boolean getBTactive(){
        return BTactive;
    }
    
//methode permettant de modifier une météo en BonTemps
    public void ModifieMeteoBT(BonTemps bon){
        this.temperature=bon.getTemperature();
        this.humidite=bon.getHumidite();
        this.BTactive = true;
        this.MTactive = false;
    }
    
//methode permettant de modifier une météo en MauvaisTemps
    public void ModifieMeteoMT(MauvaisTemps mauvais){
        this.temperature=mauvais.getTemperature();
        this.humidite=mauvais.getHumidite();
        this.BTactive = false;
        this.MTactive = true;
    }

}
