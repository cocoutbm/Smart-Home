package Smart_Home_Systeme;

public class MauvaisTemps extends Meteo {
    public MauvaisTemps() {
        super();
    }

    public MauvaisTemps(float hum, float temp) {
        super(hum, temp);
    }

    public void diminueTemperature() {
        this.temperature -= 1;
    }

    public void augmenteHumidite() {
        this.humidite += 2;
    }
}