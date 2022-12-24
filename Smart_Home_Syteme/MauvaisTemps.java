package Smart_Home_Syteme;

public class MauvaisTemps extends Meteo {
    public MauvaisTemps() {
        super();
    }

    public MauvaisTemps(float hum, float temp) {
        super(hum, temp);
    }

    public void diminueTemp() {
        this.temperature -= 1;
    }

    public void augmenteHum() {
        this.humidite += 2;
    }
}
