package Smart_Home_Systeme;

public class Meteo {

    protected float humidite;
    protected float temperature;

    public Meteo(){
        this.humidite=40;
        this.temperature=22;
    }

    public Meteo(float hum, float temp){
        this.humidite=hum;
        this.temperature=temp;

    }

    public void ModifieMaison(){




    }

    public float getHumidite() {
        return humidite;
    }
    public float getTemperature() {
        return temperature;
    }
}