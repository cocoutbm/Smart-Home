package Smart_Home_Systeme;

public class Meteo {

    protected float humidite;
    protected float temperature;

    public Meteo(){
        this.humidite=0;
        this.temperature=0;
    }

    public Meteo(float hum, float temp){
        this.humidite=hum;
        this.temperature=temp;
    }

    public float getHumidite() {
        return humidite;

    }
    public void setHumidite(float hum) {
        this.humidite = hum;
    }

    public float getTemperature() {
        return temperature;
    }
    public void setTemperature(float temp) {
        this.temperature = temp;
    }

    public void ModifieMeteoBT(BonTemps bon){
        this.temperature=bon.getTemperature();
        bon.setTemperature(0);
        this.humidite=bon.getHumidite();
        bon.setHumidite(0);
    }

    public void ModifieMeteoMT(MauvaisTemps mauvais){
        this.temperature=mauvais.getTemperature();
        mauvais.setTemperature(0);
        this.humidite=mauvais.getHumidite();
        mauvais.setHumidite(0);
    }
}