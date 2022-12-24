package Smart_Home_Syteme;

public class BonTemps extends Meteo {
    public BonTemps() {
        super();
    }

    public BonTemps(float hum, float temp) {
        super(hum, temp);
    }

    public void augmenteTemp() {
        this.temperature += 1;
    }

    public void diminueHum() {
        this.humidite -= 2;
    }
    //
}
