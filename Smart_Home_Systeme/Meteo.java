package Smart_Home_Systeme;

public class Meteo {

    protected double humidite;
    protected double temperature;
    private  boolean MTactive;
    private boolean BTactive;

    public Meteo(){
        this.humidite=55;
        this.temperature=23;
        this.MTactive = false;
        this.BTactive = true;
    }

    public Meteo(double hum, double temp, boolean mtactive, boolean btactive){
        this.humidite=hum;
        this.temperature=temp;
        this.MTactive = mtactive;
        this.BTactive = btactive;
    }

    public double getHumidite() {
        return humidite;

    }
    public void setHumidite(double hum) {
        this.humidite = hum;
    }

    public double getTemperature() {
        return temperature;
    }
    public void setTemperature(double temp) {
        this.temperature = temp;
    }

    public boolean getMTactive(){
        return MTactive;
    }

    public boolean getBTactive(){
        return BTactive;
    }

    public void ModifieMeteoBT(BonTemps bon){
        this.temperature=bon.getTemperature();
        this.humidite=bon.getHumidite();
        this.BTactive = true;
        this.MTactive = false;
    }

    public void ModifieMeteoMT(MauvaisTemps mauvais){
        this.temperature=mauvais.getTemperature();
        this.humidite=mauvais.getHumidite();
        this.BTactive = false;
        this.MTactive = true;
    }

}