package Smart_Home_Systeme;

public class Meteo {

    protected float humidite;
    protected float temperature;
    private Maison maison;

    public Meteo(){
        this.humidite=40;
        this.temperature=22;
    }

    public Meteo(float hum, float temp){
        this.humidite=hum;
        this.temperature=temp;

    }

    public void modifieMaison(){
        maison.setTemperature(this.temperature);
        maison.setHumidite(this.humidite);
    }

    public float getHumidite() {
        return humidite;

    }
    public void setHumidite(float hum) {
        this.humidite = hum;
        modifieMaison();

    }

    public float getTemperature() {
        return temperature;
    }
    public void setTemperature(float temp) {
        this.temperature = temp;
        modifieMaison();

    }

}